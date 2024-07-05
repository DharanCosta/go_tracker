package go.tracker.api.request

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class PhoneRequest(
    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotBlank
    @field: Size(max = 20)
    var number: String? = null,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotBlank
    @field: Size(max = 3)
    var ddd: Int? = null
) {

}
