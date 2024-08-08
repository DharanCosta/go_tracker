package go.tracker.domain.service

import go.tracker.models.user.Trainer
import go.tracker.persistence.service.TrainerPersistenceService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service("TrainerService")
class TrainerService(
    private val trainerPersistenceService: TrainerPersistenceService,
    private val passwordEncoder: PasswordEncoder
) {
     fun create(trainer: Trainer): Trainer {

        trainer.password = encodePassword(trainer.password!!)

        return trainerPersistenceService.createTrainer(trainer)
    }

    fun encodePassword(rawPassword: String): String {
        return passwordEncoder.encode(rawPassword)
    }
}