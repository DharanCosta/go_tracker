package go.tracker.domain.service

import go.tracker.models.exceptions.InvalidUsernamePasswordException
import go.tracker.models.user.UserLogin
import go.tracker.persistence.service.UserPersistenceService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.Optional
import kotlin.jvm.Throws

@Service
class UserService(
    private val userPersistenceService: UserPersistenceService,
    private val passwordEncoder: PasswordEncoder
) {
    @Throws(InvalidUsernamePasswordException::class)
    fun getUserLogin(username: String):Optional<UserLogin>? {
        var response: Optional<UserLogin>? = Optional.empty()
            userPersistenceService.findByEmail(username).ifPresent { user ->
                   response = Optional.of(UserLogin(email = user.email, password = user.password))
                }
        return response
    }

    fun matchingPasswords(requestPassword: String, password: String): Boolean {
        return encodePassword(password) == requestPassword
    }

    fun encodePassword(rawPassword: String): String {
        return passwordEncoder.encode(rawPassword)
    }
}