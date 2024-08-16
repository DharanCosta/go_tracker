package go.tracker.domain.service

import go.tracker.models.enums.UserType
import go.tracker.models.exceptions.InvalidTrainerStatusException
import go.tracker.models.exceptions.TrainerNotFoundException
import go.tracker.models.trainer.Trainer
import go.tracker.models.trainer.TrainerStatus
import go.tracker.persistence.service.TrainerPersistenceService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import kotlin.jvm.Throws
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
        trainerPersistenceService.findByEmail(trainerStatus.username!!).ifPresent {
            if(validateTrainerStatus(trainerStatus, it.id!!)) {
                trainerPersistenceService.createTrainerStatusEntry(trainerStatus)
            }
        }
    }

    @Throws(InvalidTrainerStatusException::class)
    private fun validateTrainerStatus(trainerStatus: TrainerStatus, trainerId: Long): Boolean {
        val trainerStatusEntity = trainerPersistenceService.findLastTrainerStatus(trainerId)

        if (trainerStatusEntity != null) {
            require(trainerStatusEntity.xp!! < trainerStatus.xp!!) {
                throw InvalidTrainerStatusException("XP in the new status cannot be less than the existing XP")
            }
            require (trainerStatusEntity.catches!! < trainerStatus.catches!!) {
                throw InvalidTrainerStatusException("Catches in the new status cannot be less than the existing catches")
            }
        }
        return true
    }
}
