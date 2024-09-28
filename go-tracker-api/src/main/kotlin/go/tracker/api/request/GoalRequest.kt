package go.tracker.api.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import go.tracker.api.common.validation.constraint.annotation.ValidEnumList
import go.tracker.models.enums.GoalType
import go.tracker.models.enums.Medals
import go.tracker.models.trainer.TrainerGoal
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

data class GoalRequest(
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

    @JsonProperty(value = "end_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @field: Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @field: NotNull
    val endDate: LocalDate? = null
) {
    fun toDomain(request: GoalRequest): TrainerGoal =
        TrainerGoal().apply {
            goalType = request.goalType
            medalName = request.goalName
            goalValue = request.goalValue
            endDate = LocalDateTime.of(request.endDate, LocalTime.MAX)
        }
}