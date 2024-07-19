package go.tracker.domain.common

data class MessageCode(
    val name: String
) {
    companion object {
        const val INVALID_FIELD = "invalid.field"
    }

}
