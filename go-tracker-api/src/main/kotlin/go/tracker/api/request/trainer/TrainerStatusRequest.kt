package go.tracker.api.request.trainer

import go.tracker.models.trainer.TrainerStatus
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotNull

data class TrainerStatusRequest(
    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull
    val xp: Long? = null,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull
    val dust: Long? = null,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull
    val catches: Long? = null
) {
    fun toDomain(request: TrainerStatusRequest, username: String): TrainerStatus =
        TrainerStatus().apply {
            xp = request.xp
            dust = request.dust
            catches = request.catches
            this.username = username
        }
}