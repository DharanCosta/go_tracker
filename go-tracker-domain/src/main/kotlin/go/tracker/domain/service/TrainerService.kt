package go.tracker.domain.service

import go.tracker.models.user.Trainer
import go.tracker.persistence.service.TrainerPersistenceService
import org.springframework.stereotype.Service

@Service("TrainerService")
class TrainerService(
    private val trainerPersistenceService: TrainerPersistenceService,
) {
    fun create(trainer: Trainer): Trainer {
        return trainerPersistenceService.createTrainer(trainer)
    }
}