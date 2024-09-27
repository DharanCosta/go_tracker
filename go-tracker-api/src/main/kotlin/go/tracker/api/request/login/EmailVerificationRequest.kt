package go.tracker.api.request.login

import jakarta.validation.constraints.NotNull

data class EmailVerificationRequest (
    @NotNull
    val email: String?= null
)