package go.tracker.persistence.mapper

import brave.internal.collect.UnsafeArrayMap.Mapper
import go.tracker.models.trainer.TrainerStatus
import go.tracker.persistence.entity.trainer.TrainerStatusEntity
import java.time.LocalDateTime

val ToTrainerStatusToEntity  =
    Mapper<TrainerStatus, TrainerStatusEntity> { status ->
       TrainerStatusEntity().apply {
           xp = status.xp
           dust = status.dust
           catches = status.catches
           entryDate = LocalDateTime.now()
       }

}
