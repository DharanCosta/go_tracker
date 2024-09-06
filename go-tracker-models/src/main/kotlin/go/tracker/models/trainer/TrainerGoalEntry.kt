package go.tracker.models.trainer

import go.tracker.models.enums.GoalType
import go.tracker.models.enums.Medals
import java.time.LocalDateTime

data class TrainerGoalEntry (
    var id: Long? = null,
    var goalType: GoalType? = null,
    var medalName: Medals? = null,
    var goalValue: Long? = null,
    var entryDate: LocalDateTime? = LocalDateTime.now(),
    var trainer: Trainer? = null,
    var trainerGoal: TrainerGoal? = null
)