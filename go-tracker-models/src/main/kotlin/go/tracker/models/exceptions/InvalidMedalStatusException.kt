package go.tracker.models.exceptions

class InvalidMedalStatusException (val medal: String, val maxValue: String): RuntimeException("Maximum number of $medal type already reached. Max allowed is $maxValue.")