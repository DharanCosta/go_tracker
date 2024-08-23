package go.tracker.models.trainer

import go.tracker.models.enums.Medals
import java.time.LocalDateTime

data class TrainerMedalStatus (
    var id: Long? = null,
    var medal: Medals? = null,
    var value: Long? = null,
    var trainer: Trainer? = null,
    var datCreated: LocalDateTime? = LocalDateTime.now()
)