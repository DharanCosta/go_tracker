package go.tracker.api.response.medals

import go.tracker.models.trainer.TrainerGoal

data class TrainerGoalsResponse(
    val trainerGoals: List<TrainerGoal>
)