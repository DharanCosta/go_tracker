package go.tracker.persistence.mapper.to.entity

import brave.internal.collect.UnsafeArrayMap.Mapper
import go.tracker.models.trainer.TrainerStatus
import go.tracker.persistence.entity.trainer.TrainerStatusEntity
import java.time.LocalDateTime

val ToTrainerStatusEntity  =
    Mapper<TrainerStatus, TrainerStatusEntity> { status ->
       TrainerStatusEntity().apply {
           xp = status.xp
           dust = status.dust
           catches = status.catches
           entryDate = LocalDateTime.now()
       }
}