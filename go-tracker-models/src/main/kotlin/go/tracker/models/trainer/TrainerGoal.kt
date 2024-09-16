package go.tracker.models.trainer

import go.tracker.models.enums.GoalType
import go.tracker.models.enums.Medals
import java.math.BigDecimal
import java.time.LocalDateTime

data class TrainerGoal(
    var id: Long? = null,
    var goalType: GoalType? = null,
    var medalName: Medals? = null,
    var goalValue: BigDecimal? = null,
    var startDate: LocalDateTime? = LocalDateTime.now(),
    var endDate: LocalDateTime? = LocalDateTime.now(),
    var trainer: Trainer? = null
)