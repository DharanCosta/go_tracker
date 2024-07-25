package go.tracker.api.request

import go.tracker.domain.common.MessageCode
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class AddressRequest(
    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotBlank (message = MessageCode.REQUIRED_FIELD)
    @field: Size(max = 50)
    var country: String? = "",

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotBlank (message = MessageCode.REQUIRED_FIELD)
    @field: Size(max = 50)
    var state: String = "",

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotBlank (message = MessageCode.REQUIRED_FIELD)
    @field: Size(max = 50)
    var city: String = "",

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
//    @field: NotBlank (message = MessageCode.REQUIRED_FIELD)
    @field: Size(max = 50)
    var coordinates: String = ""
) {

}
