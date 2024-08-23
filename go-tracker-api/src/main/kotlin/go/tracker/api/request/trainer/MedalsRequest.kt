package go.tracker.api.request.trainer

import com.fasterxml.jackson.annotation.JsonProperty
import go.tracker.models.trainer.TrainerMedalStatus
import jakarta.validation.Valid

data class MedalsRequest (
    @field:Valid
    @JsonProperty(value = "medals")
    val medalStatusRequests: List<MedalStatusRequest>
) {
    fun toDomainList(request:MedalsRequest): List<TrainerMedalStatus> =
        request.medalStatusRequests.map { it.toDomain(it) }
}