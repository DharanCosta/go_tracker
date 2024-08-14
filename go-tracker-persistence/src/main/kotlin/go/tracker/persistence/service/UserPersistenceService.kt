package go.tracker.persistence.service

import go.tracker.persistence.entity.user.AppUserEntity
import go.tracker.persistence.repository.user.UserRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UserPersistenceService (
    private val userRepository: UserRepository
){
    fun findByEmail(email: String): Optional<AppUserEntity> =
        userRepository.findByEmail(email)
}