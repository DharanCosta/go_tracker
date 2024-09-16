package go.tracker.api.request.trainer

import go.tracker.models.trainer.TrainerStatus
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class TrainerStatusRequest(
    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull
    val xp: BigDecimal? = null,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull
    val dust: BigDecimal? = null,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull
    val catches: BigDecimal? = null,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull
    val pokestops: BigDecimal? = null,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull
    val distance: BigDecimal? = null
) {
    fun toDomain(request: TrainerStatusRequest, username: String): TrainerStatus =
        TrainerStatus().apply {
            xp = request.xp
            dust = request.dust
            catches = request.catches
            pokestops = request.pokestops
            distance = request.distance
            this.username = username
        }
}