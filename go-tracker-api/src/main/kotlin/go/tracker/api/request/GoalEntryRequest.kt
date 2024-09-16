package go.tracker.api.request

import com.fasterxml.jackson.annotation.JsonProperty
import go.tracker.api.common.validation.constraint.annotation.ValidEnumList
import go.tracker.models.enums.GoalType
import go.tracker.models.enums.Medals
import go.tracker.models.trainer.TrainerGoalEntry
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class GoalEntryRequest(
    @JsonProperty(value = "type")
    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull
    @field: ValidEnumList(enumClass = GoalType::class, message = "Invalid goal type")
    val goalType: GoalType? = null,

    @JsonProperty(value = "medal_name")
    @field: Schema(requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @field: NotNull
    @field:ValidEnumList(enumClass = Medals::class, message = "Invalid goal name, must be a medal")
    val goalName: Medals? = null,

    @JsonProperty(value = "value")
    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull
    val goalValue: BigDecimal? = null,
) {
    fun toDomain(request: GoalEntryRequest): TrainerGoalEntry =
        TrainerGoalEntry().apply {
            goalType = request.goalType
            medalName = request.goalName
            goalValue = request.goalValue
        }
}