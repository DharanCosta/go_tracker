package go.tracker.api.resource

import go.tracker.api.request.trainer.TrainerStatusRequest
import go.tracker.api.request.trainer.MedalsRequest
import go.tracker.api.response.TrainerProfileResponse
import go.tracker.api.swagger.CreateTrainerMedalStatusSwaggerAPI
import go.tracker.api.swagger.CreateTrainerStatusSwaggerAPI
import go.tracker.api.swagger.TrainerProfileSwaggerAPI
import go.tracker.domain.service.TrainerService
import go.tracker.models.exceptions.InvalidCredentialsException
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*

@Tag(name = TrainerResource.TAG, description = "Serviço de pesquisa e atualização de usuários")
@RequestMapping(TrainerResource.RESOURCE_PATH)
@RestController
class TrainerResource(
    private val trainerService: TrainerService,
) {
    companion object {
        const val RESOURCE_PATH = "/trainer"
        const val TAG = "Trainer Service"
    }

    @TrainerProfileSwaggerAPI
    @GetMapping("/{ign}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTrainerProfile(@PathVariable ign: String): ResponseEntity<TrainerProfileResponse> =
        ResponseEntity.ok(TrainerProfileResponse().toResponse(trainerService.findTrainer(ign)))


    @CreateTrainerStatusSwaggerAPI
    @PostMapping("/status")
    fun updateTrainerStatus(@RequestBody trainerStatusRequest: TrainerStatusRequest) : ResponseEntity<Unit>{
        val username = getAuthenticatedUsername()

        return  if (username != null) {
            trainerService.createStatusEntry(trainerStatusRequest.toDomain(trainerStatusRequest, username))
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.noContent().build()
        }
    }

    @CreateTrainerMedalStatusSwaggerAPI
    @PostMapping("/medal")
    fun updateTrainerStatus(@RequestBody medalsRequest: MedalsRequest) : ResponseEntity<Unit>{
        val username = getAuthenticatedUsername()

        return  if (username != null) {
            trainerService.createMedalStatusEntry(medalsRequest.toDomainList(medalsRequest), username)
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.noContent().build()
        }
    }

    @Throws(InvalidCredentialsException::class)
    fun getAuthenticatedUsername(): String? {
        val authentication = SecurityContextHolder.getContext().authentication

        return if (authentication != null && authentication.principal is UserDetails) {
            val userDetails = authentication.principal as UserDetails
            userDetails.username
        } else {
            throw InvalidCredentialsException()
        }
    }
}