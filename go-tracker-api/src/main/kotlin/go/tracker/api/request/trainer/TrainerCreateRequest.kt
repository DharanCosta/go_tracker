package go.tracker.api.request.trainer

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import go.tracker.api.common.validation.constraint.annotation.UniqueFields
import go.tracker.api.common.validation.constraint.annotation.ValidName
import go.tracker.domain.common.MessageCode
import go.tracker.models.user.Address
import go.tracker.models.user.Phone
import go.tracker.models.trainer.Trainer
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate

@UniqueFields
data class TrainerCreateRequest(
    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotBlank (message = MessageCode.REQUIRED_FIELD)
    @field: Size(max = 100)
    var email: String? = "",

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotBlank (message = MessageCode.REQUIRED_FIELD)
    @field: Size(max = 50)
    var password: String? = "",

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: ValidName
    @field: NotBlank (message = MessageCode.REQUIRED_FIELD)
    @field: Size(max = 150)
    var name: String? = "",

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull (message = MessageCode.REQUIRED_FIELD)
    @field: JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @field: JsonProperty("birth_date")
    var birthDate: LocalDate? = LocalDate.now(),

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotBlank (message = MessageCode.REQUIRED_FIELD)
    @field: Size(max = 50)
    var ign: String? = "",

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull (message = MessageCode.REQUIRED_FIELD)
    var level: Int? = 0,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @field: JsonProperty("start_date")
    var startDate: LocalDate = LocalDate.now(),

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull (message = MessageCode.REQUIRED_FIELD)
    @field: JsonProperty("initial_xp")
    var initialXP: Long? = null,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull (message = MessageCode.REQUIRED_FIELD)
    @field: JsonProperty("initial_catch")
    var initialCatch: Long? = null,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    var public: Boolean? = false,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: Valid
    var address: AddressRequest? = null,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: Valid
    var phone: PhoneRequest? = null
) {
    fun toDomain(trainerRequest: TrainerCreateRequest): Trainer {
        return Trainer().apply {
            email = trainerRequest.email
            password = trainerRequest.password
            name = trainerRequest.name
            birthDate = trainerRequest.birthDate
            ign = trainerRequest.ign
            level = trainerRequest.level
            startDate = trainerRequest.startDate
            initialXP = trainerRequest.initialXP
            initialCatch = trainerRequest.initialCatch
            public = trainerRequest.public
            address = Address().apply {
                country = trainerRequest.address?.country
                city = trainerRequest.address?.city
                state = trainerRequest.address?.state
                coordinates = trainerRequest.address?.coordinates
            }
            phone = Phone().apply {
               number = trainerRequest.phone?.number
            }
        }
    }
}
