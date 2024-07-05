package models.user

data class Address (
    var id: Long? = null,
    var country: String? = "",
    var state: String = "",
    var city: String = "",
    var coordinates: String = ""
)