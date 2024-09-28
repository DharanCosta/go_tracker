package go.tracker.persistence.service

import go.tracker.models.enums.Medals
import go.tracker.models.trainer.*
import go.tracker.persistence.entity.trainer.TrainerStatusEntity
import go.tracker.persistence.mapper.to.entity.*
import go.tracker.persistence.mapper.to.model.ToMedalStatusMapper
import go.tracker.persistence.mapper.to.model.ToTrainer
import go.tracker.persistence.mapper.to.model.ToTrainerMapper
import go.tracker.persistence.repository.GoalEntryRepository
import go.tracker.persistence.repository.GoalsRepository
import go.tracker.persistence.repository.trainer.MedalStatusRepository
import go.tracker.persistence.repository.trainer.TrainerRepository
import go.tracker.persistence.repository.trainer.TrainerStatusRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class TrainerPersistenceService(
    private val trainerRepository: TrainerRepository,
    private val trainerStatusRepository: TrainerStatusRepository,
    private val medalStatusRepository: MedalStatusRepository,
    private val goalsRepository: GoalsRepository,
    private val goalEntry: GoalEntryRepository
) {
    fun existByIgn(ign: String): Boolean = trainerRepository.existsByIgn(ign)

    fun existByEmail(email: String): Boolean = trainerRepository.existsByEmail(email)

    fun createTrainer(trainer: Trainer): Trainer =
        trainerRepository.save(ToTrainerEntityMapper.map(trainer))
            .let { ToTrainerMapper.map(it) }

    fun findByIgn(ign: String): Optional<Trainer> =
        trainerRepository.findByIgn(ign).map(ToTrainer::map)

    fun findByEmail(email: String): Optional<Trainer> =
        trainerRepository.findByEmail(email).map(ToTrainer::map)

    fun findLastTrainerStatus(id: Long): TrainerStatusEntity? =
        trainerStatusRepository.findTopByTrainerIdOrderByEntryDateDesc(id)

    @Transactional
    fun createTrainerStatusEntry(trainerStatus: TrainerStatus) {
        trainerStatus.username?.let {
            trainerRepository.findByEmail(it).let { trainerEntity ->
                trainerStatusRepository.save(
                    ToTrainerStatusEntity.map(trainerStatus).apply { trainer = trainerEntity.get() }
                )
            }
        }
    }

    @Transactional
    fun createMedalStatusEntry(medalStatusList: List<TrainerMedalStatus>, trainer: Trainer) {
        val trainerEntity = ToTrainerEntityMapper.map(trainer)
        val medalStatusEntities = medalStatusList.map { medalStatus ->
            ToMedalStatusToEntity.map(medalStatus).apply { this.trainer = trainerEntity }
        }
        medalStatusRepository.saveAll(medalStatusEntities)
    }

    fun findMedalStatus(trainer: Trainer, medals: Medals): Optional<TrainerMedalStatus>? {
        var medalStatus: Optional<TrainerMedalStatus>? = null
        medalStatusRepository.findLastMedalEntriesForTrainer(medals, trainer.id!!).map {
            medalStatus = Optional.of(ToMedalStatusMapper.map(it))
        }
        return medalStatus
    }

    @Transactional
    fun findLastMedalStatus(id: Long): MutableList<TrainerMedalStatus> {
        val responseList: MutableList<TrainerMedalStatus> = mutableListOf()
        val toList = Medals.entries.map { it.name }
        medalStatusRepository.findLastMedalsEntriesForTrainer(toList, id).let { list ->
            if (list!!.isNotEmpty()) {
                list.forEach { medalStatus ->
                    responseList.add(ToMedalStatusMapper.map(medalStatus!!))
                }
            }
        }
        return responseList
    }

    @Transactional
    fun createTrainerGoals(trainerGoals: List<TrainerGoal>, trainer: Trainer) {
        val trainerEntity = ToTrainerEntityMapper.map(trainer)
        goalsRepository.saveAll(trainerGoals.map { ToGoalsEntity.map(it).apply { this.trainer = trainerEntity } })
    }

    @Transactional
    fun createTrainerGoalEntry(trainerGoalEntry: List<TrainerGoalEntry>) {
        goalEntry.saveAll(trainerGoalEntry.map { ToGoalsEntryEntity.map(it) })
    }
}