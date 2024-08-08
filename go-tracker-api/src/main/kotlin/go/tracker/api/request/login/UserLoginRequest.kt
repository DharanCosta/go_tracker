package go.tracker.api.request.login

import go.tracker.domain.common.MessageCode
import go.tracker.models.user.UserLogin
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UserLoginRequest(
    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotBlank(message = MessageCode.REQUIRED_FIELD)
    @field: Size(max = 100)
    val username: String,

    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotBlank (message = MessageCode.REQUIRED_FIELD)
    @field: Size(max = 50)
    val password: String
){
    fun toDomain(request: UserLoginRequest): UserLogin =
        UserLogin().apply {
            this.email = request.username
            this.ign = request.username
            this.password = request.password
        }
}