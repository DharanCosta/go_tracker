package go.tracker.domain.service

import go.tracker.persistence.service.TrainerPersistenceService
import org.springframework.stereotype.Service

@Service
class RequestValidatorService (
    private val userPersistenceService: TrainerPersistenceService
){
    fun existTrainer(ign: String): Boolean = userPersistenceService.existByIgn(ign)

    fun existEmail(email: String): Boolean = userPersistenceService.existByEmail(email)
}