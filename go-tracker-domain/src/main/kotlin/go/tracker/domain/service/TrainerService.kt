package go.tracker.domain.service

import go.tracker.models.user.Trainer
import go.tracker.persistence.service.UserPersistenceService
import org.springframework.stereotype.Service

@Service("TrainerService")
class TrainerService(
    private val userPersistenceService: UserPersistenceService,
) {
    fun create(trainer: Trainer): Trainer {
        return userPersistenceService.createTrainer(trainer) as Trainer
    }

}