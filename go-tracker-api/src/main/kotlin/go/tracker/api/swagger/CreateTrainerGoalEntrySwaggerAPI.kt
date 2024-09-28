package go.tracker.api.swagger

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springdoc.api.ErrorMessage

@Operation(description = "Criação de entrada para meta")
@ApiResponses(
    value = [
        ApiResponse(
            responseCode = "200",
            description = "Entrada de meta cadastrada",
            content = [
                Content(
                    mediaType = "application/json"
                )
            ]
        ),
        ApiResponse(
            responseCode = "204",
            description = "Entrada de meta não cadastrado",
            content = [
                Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = ErrorMessage::class)
                )
            ]
        ),
        ApiResponse(
            responseCode = "400",
            description = "Entrada de meta inválida",
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
annotation class CreateTrainerGoalEntrySwaggerAPI
