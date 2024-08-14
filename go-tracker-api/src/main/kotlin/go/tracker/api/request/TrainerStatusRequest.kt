package go.tracker.api.request

import go.tracker.models.trainer.TrainerStatus

data class TrainerStatusRequest(
    val xp: Long? = null,
    val dust: Long? = null,
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