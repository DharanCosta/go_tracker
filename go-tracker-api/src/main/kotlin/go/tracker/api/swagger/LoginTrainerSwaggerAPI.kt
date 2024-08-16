package go.tracker.api.swagger

import go.tracker.api.response.login.UserLoginResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springdoc.api.ErrorMessage

@Operation(description = "Login de um treinador")
@ApiResponses(value = [
        ApiResponse(
            responseCode = "200",
            description = "Treinador Logado com sucesso",
            content = [
                Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = UserLoginResponse::class )
                )
        ]),
        ApiResponse(
            responseCode = "401",
            description = "Login não autorizado/Credenciais inválidas",
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
annotation class LoginTrainerSwaggerAPI