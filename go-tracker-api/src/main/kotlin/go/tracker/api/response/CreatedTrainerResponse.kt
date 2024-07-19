package go.tracker.api.response

import go.tracker.models.user.Trainer

data class CreatedTrainerResponse (
    var trainer: String? = null,
) {
    fun toResponse(domain: Trainer?) : CreatedTrainerResponse =
        CreatedTrainerResponse().apply { trainer = domain?.ign }
}
