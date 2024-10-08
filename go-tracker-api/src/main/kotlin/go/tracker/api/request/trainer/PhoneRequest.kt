package go.tracker.api.request.trainer

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class PhoneRequest(
    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotBlank
    @field: Size(max = 20)
    var number: String? = null,
)
