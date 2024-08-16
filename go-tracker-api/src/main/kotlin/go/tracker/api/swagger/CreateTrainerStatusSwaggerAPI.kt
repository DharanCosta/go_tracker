package go.tracker.api.swagger

import go.tracker.api.response.login.UserLoginResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springdoc.api.ErrorMessage

@Operation(description = "Status Created")
@ApiResponses(
    value = [
        ApiResponse(
            responseCode = "200",
            description = "Status cadastrado",
            content = [
                Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = UserLoginResponse::class)
                )
            ]
        ),
        ApiResponse(
            responseCode = "204",
            description = "Status não cadastrado",
            content = [
                Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = ErrorMessage::class)
                )
            ]
        ),
        ApiResponse(
            responseCode = "400",
            description = "Status inválidos",
            content = [
                Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = ErrorMessage::class)
                )
            ]
        ),
        ApiResponse(
            responseCode = "401",
            description = "Credenciais inválidas",
            content = [
                Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = ErrorMessage::class)
                )
            ]
        )
    ]
)
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class CreateTrainerStatusSwaggerAPI
