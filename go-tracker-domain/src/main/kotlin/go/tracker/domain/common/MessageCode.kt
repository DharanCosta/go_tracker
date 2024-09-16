package go.tracker.domain.common

data class MessageCode(
    val name: String
) {
    companion object {
        const val TRAINER_NOT_FOUND = "trainer.not.found"
        const val TRAINER_MEDAL_STATUS_NOT_FOUND = "trainer.medal.status.not.found"
        const val TRAINER_GOALS_NOT_FOUND = "trainer.goals.not.found"
        const val REQUIRED_FIELD = "required.field"
        const val UNIQUE_FIELD_VIOLATION = "unique.field.violation"
        const val INVALID_FIELD = "invalid.field"
        const val INVALID_TRAINER_STATUS = "invalid.trainer.status"
        const val INVALID_MEDAL_STATUS = "invalid.medal.status"
    }
}
