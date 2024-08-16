package go.tracker.persistence.service

import go.tracker.models.trainer.Trainer
import go.tracker.models.trainer.TrainerStatus
import go.tracker.persistence.entity.trainer.TrainerStatusEntity
import go.tracker.persistence.mapper.ToTrainerStatusToEntity
import go.tracker.persistence.mapper.to.entity.ToTrainerEntityMapper
import go.tracker.persistence.mapper.to.model.ToTrainer
import go.tracker.persistence.mapper.to.model.ToTrainerMapper
import go.tracker.persistence.repository.trainer.TrainerRepository
import go.tracker.persistence.repository.trainer.TrainerStatusRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TrainerPersistenceService(
    private val trainerRepository: TrainerRepository,
    private val trainerStatusRepository: TrainerStatusRepository
) {
    fun existByIgn(ign: String): Boolean = trainerRepository.existsByIgn(ign)

    fun existByEmail(email: String): Boolean = trainerRepository.existsByEmail(email)

    fun createTrainer(trainer: Trainer): Trainer =
        trainerRepository.save(ToTrainerEntityMapper.map(trainer))
            . let { ToTrainerMapper.map(it)}

    fun findByIgn(ign: String): Optional<Trainer>  =
        trainerRepository.findByIgn(ign).map(ToTrainer::map)

    fun findByEmail(email: String): Optional<Trainer>  =
        trainerRepository.findByEmail(email).map(ToTrainer::map)

    fun findLastTrainerStatus(id: Long): TrainerStatusEntity? =
        trainerStatusRepository.findTopByTrainerIdOrderByEntryDateDesc(id)

    fun createTrainerStatusEntry(trainerStatus: TrainerStatus) {
         trainerStatus.username?.let {
             trainerRepository.findByEmail(it).let { trainerEntity ->
                 trainerStatusRepository.save(
                     ToTrainerStatusToEntity.map(trainerStatus).apply { trainer = trainerEntity.get() }
                 )
             }
         }
    }
}