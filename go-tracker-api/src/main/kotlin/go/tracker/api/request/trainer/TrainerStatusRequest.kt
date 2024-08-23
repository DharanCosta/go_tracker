package go.tracker.api.request.trainer

import go.tracker.models.trainer.TrainerStatus
import io.swagger.v3.oas.annotations.media.Schema

data class TrainerStatusRequest(
    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    val xp: Long? = null,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    val dust: Long? = null,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
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