package go.tracker.api.resource

import go.tracker.api.request.GoalEntryRequest
import go.tracker.api.request.GoalRequest
import go.tracker.api.request.trainer.MedalsRequest
import go.tracker.api.request.trainer.TrainerStatusRequest
import go.tracker.api.response.TrainerProfileResponse
import go.tracker.api.response.medals.MedalStatusResponse
import go.tracker.api.response.medals.TrainerGoalsResponse
import go.tracker.api.swagger.*
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

    @FindTrainerProfileSwaggerAPI
    @GetMapping("/{ign}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTrainerProfile(@PathVariable ign: String): ResponseEntity<TrainerProfileResponse> =
        ResponseEntity.ok(TrainerProfileResponse().toResponse(trainerService.findTrainer(ign)))


    @CreateTrainerStatusSwaggerAPI
    @PostMapping("/status")
    fun updateTrainerStatus(@RequestBody trainerStatusRequest: TrainerStatusRequest): ResponseEntity<Unit> {
        val username = getAuthenticatedUsername()

        return if (username != null) {
            trainerService.createStatusEntry(trainerStatusRequest.toDomain(trainerStatusRequest, username))
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.noContent().build()
        }
    }

    @FindTrainerLastMedalStatusSwaggerAPI
    @GetMapping("/medals", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getLastMedalStatus(): ResponseEntity<MedalStatusResponse> {
        val username = getAuthenticatedUsername()

        return ResponseEntity.ok(
            MedalStatusResponse().mapToMedalStatusResponse(
                trainerService.findLastMedalStatus(username!!)
            )
        )
    }

    @CreateTrainerMedalStatusSwaggerAPI
    @PostMapping("/medals")
    fun updateTrainerStatus(@RequestBody medalsRequest: MedalsRequest): ResponseEntity<Unit> {
        val username = getAuthenticatedUsername()

        return if (username != null) {
            trainerService.createMedalStatusEntry(medalsRequest.toDomainList(medalsRequest), username)
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.noContent().build()
        }
    }

    @FindTrainerGoalsSwaggerAPI
    @GetMapping("/goals", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTrainerGoals(): ResponseEntity<TrainerGoalsResponse> {
        val username = getAuthenticatedUsername()

        return ResponseEntity.ok(
            TrainerGoalsResponse(trainerService.findTrainerGoals(username!!))
        )
    }

    @CreateTrainerGoalSwaggerAPI
    @PostMapping("/goals")
    fun createTrainerGoal(@RequestBody goalRequest: List<GoalRequest>): ResponseEntity<Unit> {
        val username = getAuthenticatedUsername()

        return if (username != null) {
            trainerService.createTrainerGoals(goalRequest.map { it.toDomain(it) }, username)
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.noContent().build()
        }
    }

    @CreateTrainerGoalEntrySwaggerAPI
    @PostMapping("/goals_entry")
    fun createTrainerGoalEntry(@RequestBody goalEntryRequest: List<GoalEntryRequest>): ResponseEntity<Unit> {
        val username = getAuthenticatedUsername()

        return if (username != null) {
            trainerService.createTrainerGoalEntry(goalEntryRequest.map { it.toDomain(it) }, username)
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