package go.tracker.models.exceptions

class UniqueFieldViolationException  (
    val field: String
): RuntimeException("field=$field")