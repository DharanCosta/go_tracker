package go.tracker.domain.service

import go.tracker.models.enums.Medals
import go.tracker.models.enums.UserType
import go.tracker.models.exceptions.*
import go.tracker.models.trainer.*
import go.tracker.models.trainer.medals.MedalsValues
import go.tracker.persistence.service.TrainerPersistenceService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*
import kotlin.jvm.optionals.getOrElse

@Service("TrainerService")
class TrainerService(
    private val trainerPersistenceService: TrainerPersistenceService,
    private val passwordEncoder: PasswordEncoder
) {
    fun createTrainer(trainer: Trainer): Trainer {
        trainer.password = encodePassword(trainer.password!!)
        trainer.type = UserType.USER
        return trainerPersistenceService.createTrainer(trainer)
    }

    @Throws(TrainerNotFoundException::class)
    fun findTrainer(ign: String): Trainer =
        trainerPersistenceService.findByIgn(ign).getOrElse { throw TrainerNotFoundException(ign) }

    fun encodePassword(rawPassword: String): String {
        return passwordEncoder.encode(rawPassword)
    }

    fun createStatusEntry(trainerStatus: TrainerStatus) {
        trainerPersistenceService.findByEmail(trainerStatus.username!!).ifPresent { trainer ->
            trainerPersistenceService.createTrainerStatusEntry(trainerStatus)
            saveInMedals(trainerStatus.catches!!, Medals.COLLECTOR, trainer)
            saveInMedals(trainerStatus.distance!!, Medals.JOGGER, trainer)
            saveInMedals(trainerStatus.pokestops!!, Medals.BACKPACKER, trainer)
        }
    }

    @Throws(MedalStatusNotFoundException::class)
    fun findLastMedalStatus(username: String): MedalsValues {
        var medalsValues = Optional.of(MedalsValues())
        trainerPersistenceService.findByEmail(username).ifPresent { trainer ->
            medalsValues = Optional.of(MedalsValues().map(trainerPersistenceService.findLastMedalStatus(trainer.id!!)))
        }
        if (!medalsValues.isPresent) throw MedalStatusNotFoundException()
        return medalsValues.get()
    }

    @Throws(InvalidMedalStatusException::class)
    fun createMedalStatusEntry(medalStatusList: List<TrainerMedalStatus>, username: String): Boolean {
        trainerPersistenceService.findByEmail(username).map { trainer ->
            medalStatusList.forEach { medalStatus ->
                if (medalStatus.medal!!.finite && hasReachedMaxAllowed(medalStatus)) {
                    throw InvalidMedalStatusException(
                        medalStatus.medal!!.medalName,
                        medalStatus.medal!!.platinum.toString()
                    )
                }
            }
            trainerPersistenceService.createMedalStatusEntry(medalStatusList, trainer)
        }
        return true
    }

    fun findTrainerGoals(username: String): List<TrainerGoal> {
        val trainer = trainerPersistenceService.findByEmail(username).get().takeIf { it.goals != null }
        if (trainer != null) {
            return trainer.goals!!.toList()
        } else throw TrainerGoalsNotFoundException()
    }

    fun createTrainerGoals(trainerGoals: List<TrainerGoal>, username: String) {
        trainerPersistenceService.findByEmail(username).map { trainer ->
            trainerPersistenceService.createTrainerGoals(trainerGoals, trainer)
        }
    }

    @Throws(InvalidTrainerGoalEntryException::class)
    fun createTrainerGoalEntry(request: List<TrainerGoalEntry>, username: String) {
        trainerPersistenceService.findByEmail(username).map { trainer ->
            val goalsEntryToAdd: MutableList<TrainerGoalEntry> = mutableListOf()
            request.forEach { goal ->
                val goalEntity = trainer.goals!!.stream().filter { it.goalType == goal.goalType }.findAny().get()
                if (trainer.goals != null && existGoal(trainer.goals!!, goal)) {
                    goalsEntryToAdd.add(goal.apply { this.trainerGoal = goalEntity })
                } else throw InvalidTrainerGoalEntryException()
            }
            if (goalsEntryToAdd.isNotEmpty()) {
                trainerPersistenceService.createTrainerGoalEntry(goalsEntryToAdd)
            }
        }
    }

    private fun existGoal(goals: List<TrainerGoal>, request: TrainerGoalEntry): Boolean {
        goals.forEach {
            if (it.goalType == request.goalType) return true
        }
        return false
    }

    private fun saveInMedals(value: BigDecimal, medal: Medals, trainer: Trainer) {
        trainerPersistenceService.createMedalStatusEntry(
            listOf(TrainerMedalStatus(value = value, medal = medal)),
            trainer
        )
    }

    private fun hasReachedMaxAllowed(medalStatus: TrainerMedalStatus): Boolean {
        val maxAllowed = medalStatus.medal!!.getMedalLimit(medalStatus.medal!!)
        return medalStatus.value?.compareTo(BigDecimal(maxAllowed))!! == 1
    }

}