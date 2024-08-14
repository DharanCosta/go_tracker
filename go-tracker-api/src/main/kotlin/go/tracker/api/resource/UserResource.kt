package go.tracker.api.resource

import go.tracker.api.request.login.UserLoginRequest
import go.tracker.api.request.trainer.TrainerCreateRequest
import go.tracker.api.response.CreatedTrainerResponse
import go.tracker.api.response.login.UserLoginResponse
import go.tracker.api.swagger.LoginTrainerSwaggerAPI
import go.tracker.api.swagger.SignUpTrainerSwaggerAPI
import go.tracker.domain.config.CustomUserDetailsService
import go.tracker.domain.service.TrainerService
import go.tracker.models.exceptions.InvalidUsernamePasswordException
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = UserResource.TAG, description = "Serviço de criação, pesquisa e atualização de usuários")
@RequestMapping(UserResource.RESOURCE_PATH)
@RestController
class UserResource(
    private val trainerService: TrainerService,
    private val userDetailsService: CustomUserDetailsService
) {

    companion object {
        const val RESOURCE_PATH = "/user"
        const val TAG = "User Service"
    }

    @LoginTrainerSwaggerAPI
    @PostMapping("/login", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun login(@RequestBody loginRequest: UserLoginRequest): ResponseEntity<UserLoginResponse> {
        return try {
            ResponseEntity.ok(UserLoginResponse(token = userDetailsService.getToken(loginRequest.username)))
        } catch (e: InvalidUsernamePasswordException) {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null)
        }
    }

    @SignUpTrainerSwaggerAPI
    @PostMapping("/signup",produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(
        @RequestBody @Valid
        @Schema(anyOf = [TrainerCreateRequest::class])
        trainerCreateRequest: TrainerCreateRequest
    ): ResponseEntity<CreatedTrainerResponse> {
        val response = CreatedTrainerResponse().toResponse(
            trainerService.createTrainer(trainerCreateRequest.toDomain(trainerCreateRequest)).also{
                userDetailsService.createUser(it.email!!, it.password!!, listOf(it.type.toString()))
            },
            userDetailsService.getToken(trainerCreateRequest.email)
        )

        return ResponseEntity(response, HttpStatus.CREATED)
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


}