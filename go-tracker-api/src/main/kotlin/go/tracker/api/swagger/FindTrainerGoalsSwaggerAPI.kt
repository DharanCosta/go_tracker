package go.tracker.api.swagger

import go.tracker.api.response.medals.MedalStatusResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springdoc.api.ErrorMessage

@Operation(description = "Encontrar metas do treinador")
@ApiResponses(value = [
        ApiResponse(
            responseCode = "201",
            description = "Metas encontradas",
            content = [
                Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = MedalStatusResponse::class )
                )
        ]),
        ApiResponse(
            responseCode = "404",
            description = "Metas não encontrada",
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
annotation class FindTrainerGoalsSwaggerAPI