package go.tracker.api.resource

import go.tracker.api.request.trainer.TrainerCreateRequest
import go.tracker.api.response.CreatedTrainerResponse
import go.tracker.api.swagger.CreateTrainerSwaggerAPI
import go.tracker.domain.service.TrainerService
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = TrainerResource.TAG, description = "Serviço de criação, pesquisa e atualização de usuários")
@RequestMapping(TrainerResource.RESOURCE_PATH)
@RestController
class TrainerResource(
    private val trainerService: TrainerService,
) {
    companion object {
        const val RESOURCE_PATH = "/trainers"
        const val TAG = "Trainer Service"
    }

    @CreateTrainerSwaggerAPI
    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(
        @RequestBody @Valid
        @Schema(anyOf = [TrainerCreateRequest::class])
        trainerCreateRequest: TrainerCreateRequest
    ): ResponseEntity<CreatedTrainerResponse> {
        val response = CreatedTrainerResponse().toResponse(
            trainerService.create(trainerCreateRequest.toDomain(trainerCreateRequest))
        )

        return ResponseEntity(response, HttpStatus.CREATED)
    }
}