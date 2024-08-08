package go.tracker.api.resource

import go.tracker.api.config.jwt.JwtUtil
import go.tracker.api.config.jwt.UserDetailsImpl
import go.tracker.api.request.login.UserLoginRequest
import go.tracker.api.response.login.UserLoginResponse
import go.tracker.domain.service.UserService
import go.tracker.models.exceptions.InvalidUsernamePasswordException
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.bind.annotation.*
import kotlin.jvm.optionals.getOrElse

@Tag(name = UserResource.TAG, description = "Serviço de criação, pesquisa e atualização de usuários")
@RequestMapping(UserResource.RESOURCE_PATH)
@RestController
class UserResource(
    private val userService: UserService,
    private val jwtUtil: JwtUtil,
) : UserDetailsService {

    companion object {
        const val RESOURCE_PATH = "/user"
        const val TAG = "User Service"
    }

    @PostMapping("/login", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun login(@RequestBody loginRequest: UserLoginRequest): ResponseEntity<UserLoginResponse> {
        return try {
            val userDetails: UserDetails = this.loadUserByUsername(loginRequest.username)
            val jwt = jwtUtil.generateToken(userDetails)
            ResponseEntity.ok(UserLoginResponse(token = jwt))
        } catch (e: InvalidUsernamePasswordException) {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null)
        }
    }

    @GetMapping("/admin")
    fun adminEndpoint(): String {
        return "Admin!";
    }

    @GetMapping("/{trainer}")
    fun userEndpoint(): String {
        return "User!";
    }

    @GetMapping("/all")
    fun allRolesEndpoint(): String {
        return "All Roles!";
    }

    @DeleteMapping("/delete")
    fun deleteEndpoint(@RequestBody s: String): String {
        return "I am deleting " + s;
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val userLogin =
            userService.getUserLogin(username!!)!!.getOrElse { throw InvalidUsernamePasswordException(username) }
        return UserDetailsImpl(userLogin)
    }
}