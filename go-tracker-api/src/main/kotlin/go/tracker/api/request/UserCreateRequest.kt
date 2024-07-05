package go.tracker.api.request

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class UserCreateRequest(
    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotBlank
    @field: Size(max = 100)
    var email: String? = "",

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotBlank
    @field: Size(max = 50)
    var password: String? = "",

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotBlank
    @field: Size(max = 150)
    var name: String? = "",

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull
    @field: Size(max = 50)
    @field: JsonProperty("birth_date")
    var birthDate: LocalDate? = LocalDate.now(),

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: Valid
    var address: AddressRequest? = null,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: Valid
    var phone: PhoneRequest? = null
) {

}
