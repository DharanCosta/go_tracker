package go.tracker.persistence.mapper.to.model

import brave.internal.collect.UnsafeArrayMap.Mapper
import go.tracker.models.trainer.TrainerGoal
import go.tracker.persistence.entity.GoalsEntity

val ToTrainerGoals =
    Mapper<MutableList<GoalsEntity>, MutableList<TrainerGoal>> { trainerGoalsEntityList ->
        trainerGoalsEntityList.map { trainerGoalsEntity ->
            TrainerGoal().apply {
                id = trainerGoalsEntity.id
                goalType = trainerGoalsEntity.goalType
                medalName = trainerGoalsEntity.medalName
                goalValue = trainerGoalsEntity.goalValue
                startDate = trainerGoalsEntity.startDate
                endDate = trainerGoalsEntity.endDate
            }
        }.toMutableList()
    }
