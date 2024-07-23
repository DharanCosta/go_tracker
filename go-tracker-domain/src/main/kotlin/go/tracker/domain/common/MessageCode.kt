package go.tracker.domain.common

data class MessageCode(
    val name: String
) {
    companion object {
        const val REQUIRED_FIELD = "required.field"
        const val UNIQUE_FIELD_VIOLATION = "unique.field.violation"
        const val INVALID_FIELD = "invalid.field"
    }

}
