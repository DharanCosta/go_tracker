package go.tracker.persistence.service

import go.tracker.models.user.Trainer
import go.tracker.models.user.User
import go.tracker.persistence.mapper.to.entity.ToTrainerEntityMapper
import go.tracker.persistence.mapper.to.model.ToTrainerMapper
import go.tracker.persistence.repository.TrainerRepository
import go.tracker.persistence.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserPersistenceService(
    private val userRepository: UserRepository,
    private val trainerRepository: TrainerRepository
) {
    fun createTrainer(trainer: Trainer): User =
        trainerRepository.save(ToTrainerEntityMapper.map(trainer))
            . let { ToTrainerMapper.map(it)}

}