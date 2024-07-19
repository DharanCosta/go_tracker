package go.tracker.models.user

data class Phone (
    var id: Long? = null,
    var number: String? = "",
    var countryCode: String? = null,
    var validated: Boolean? = false
)
