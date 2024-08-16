package go.tracker.models.exceptions

class TrainerNotFoundException  (
    val ign: String
): RuntimeException(ign)