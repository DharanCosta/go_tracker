package go.tracker.domain.config

import go.tracker.domain.service.UserService
import go.tracker.models.exceptions.InvalidUsernamePasswordException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse

@Service
class CustomUserDetailsService(
    private val userService: UserService,
    private val jwtUtil: JwtUtil,
    ) : UserDetailsService {

    fun getToken(username: String?) : String =
        jwtUtil.generateToken(this.loadUserByUsername(username))

    override fun loadUserByUsername(username: String?): UserDetails {
        val userLogin =
            userService.getUserLogin(username!!)!!.getOrElse { throw InvalidUsernamePasswordException(username) }
        return UserDetailsImpl(userLogin)
    }
}