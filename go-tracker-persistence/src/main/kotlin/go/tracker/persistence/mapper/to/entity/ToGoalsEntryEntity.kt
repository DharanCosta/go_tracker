package go.tracker.persistence.mapper.to.entity

import brave.internal.collect.UnsafeArrayMap.Mapper
import go.tracker.models.trainer.TrainerGoalEntry
import go.tracker.persistence.entity.GoalEntryEntity

val ToGoalsEntryEntity =
    Mapper<TrainerGoalEntry, GoalEntryEntity> { goalEntry ->
        GoalEntryEntity().apply {
            goal = ToGoalsEntity.map(goalEntry.trainerGoal)
            entry = goalEntry.goalValue
            date = goalEntry.entryDate
        }
    }
