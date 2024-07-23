package go.tracker.persistence.service

import go.tracker.models.user.Trainer
import go.tracker.persistence.mapper.to.entity.ToTrainerEntityMapper
import go.tracker.persistence.mapper.to.model.ToTrainer
import go.tracker.persistence.mapper.to.model.ToTrainerMapper
import go.tracker.persistence.repository.TrainerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TrainerPersistenceService(
    private val trainerRepository: TrainerRepository
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

}