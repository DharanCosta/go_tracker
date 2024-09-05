package go.tracker.persistence.mapper.to.entity

import brave.internal.collect.UnsafeArrayMap.Mapper
import go.tracker.models.trainer.TrainerGoal
import go.tracker.persistence.entity.GoalsEntity

val ToGoalsEntity  =
    Mapper<TrainerGoal, GoalsEntity> { trainerGoal ->
       GoalsEntity().apply {
           id =  trainerGoal.id
           goalType = trainerGoal.goalType
           medalName = trainerGoal.medalName
           goalValue = trainerGoal.goalValue
           startDate = trainerGoal.startDate
           endDate = trainerGoal.endDate
       }
}
