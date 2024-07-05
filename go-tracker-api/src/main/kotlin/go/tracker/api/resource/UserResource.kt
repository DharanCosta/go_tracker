package go.tracker.api.resource

import go.tracker.api.request.UserCreateRequest
import go.tracker.domain.service.UserService
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Tag(name = UserResource.TAG, description = "Serviço de criação, pesquisa e atualização de usuários")
@RestController
class UserResource(
    private val userService: UserService
) {
    companion object {
        const val RESOURCE_PATH = "/user"
        const val TAG = "User Service"
    }

//    @CreateUserSwaggerAPI
    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(
        @RequestBody @Valid
        @Schema(anyOf = [UserCreateRequest::class])
        userCreateRequest: UserCreateRequest
    ): ResponseEntity<Unit> {


        return ResponseEntity.ok().build()
    }

}