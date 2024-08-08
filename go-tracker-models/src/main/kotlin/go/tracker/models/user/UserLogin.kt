package go.tracker.models.user

class UserLogin (
    val id: Long? = null,
    var ign: String? = "",
    var email: String? = "",
    var password: String ?= "",
    var token: String ? = "",
    var role: String? = "ROLE_USER"
)