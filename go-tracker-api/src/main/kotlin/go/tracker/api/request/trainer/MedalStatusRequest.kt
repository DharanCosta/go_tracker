package go.tracker.api.request.trainer

import go.tracker.api.common.validation.constraint.annotation.ValidEnumList
import go.tracker.models.enums.Medals
import go.tracker.models.trainer.TrainerMedalStatus
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal

data class MedalStatusRequest(
    @field:ValidEnumList(enumClass = Medals::class, message = "Invalid medal status")
    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    val medal: Medals? = null,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    val value: BigDecimal? = null,
) {
    fun toDomain(request: MedalStatusRequest): TrainerMedalStatus =
        TrainerMedalStatus().apply {
            medal = Medals.valueOf(request.medal.toString())
            value = request.value
        }
}