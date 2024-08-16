package go.tracker.api.response

import go.tracker.models.trainer.Trainer

data class CreatedTrainerResponse (
    var trainer: String? = null,
    var token: String? = null
) {
    fun toResponse(domain: Trainer?, token: String?): CreatedTrainerResponse =
        CreatedTrainerResponse().apply {
            trainer = domain?.ign
            this.token = token
        }
}
