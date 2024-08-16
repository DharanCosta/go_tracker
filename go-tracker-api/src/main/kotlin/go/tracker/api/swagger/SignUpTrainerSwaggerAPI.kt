package go.tracker.api.swagger

import go.tracker.api.response.CreatedTrainerResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springdoc.api.ErrorMessage

@Operation(description = "Cria um treinador")
@ApiResponses(value = [
        ApiResponse(
            responseCode = "201",
            description = "Treinador criado com sucesso",
            content = [
                Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = CreatedTrainerResponse::class )
                )
        ]),
        ApiResponse(
            responseCode = "400",
            description = "Informações inválidas para a criação de uma nova pessoa",
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
annotation class SignUpTrainerSwaggerAPI