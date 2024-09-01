package go.tracker.persistence.service

import go.tracker.models.enums.Medals
import go.tracker.models.trainer.Trainer
import go.tracker.models.trainer.TrainerMedalStatus
import go.tracker.models.trainer.TrainerStatus
import go.tracker.persistence.entity.trainer.TrainerStatusEntity
import go.tracker.persistence.mapper.to.entity.ToMedalStatusToEntity
import go.tracker.persistence.mapper.to.entity.ToTrainerEntityMapper
import go.tracker.persistence.mapper.to.entity.ToTrainerStatusToEntity
import go.tracker.persistence.mapper.to.model.ToMedalStatusMapper
import go.tracker.persistence.mapper.to.model.ToTrainer
import go.tracker.persistence.mapper.to.model.ToTrainerMapper
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
    private val medalStatusRepository: MedalStatusRepository
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
                    ToTrainerStatusToEntity.map(trainerStatus).apply { trainer = trainerEntity.get() }
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
}