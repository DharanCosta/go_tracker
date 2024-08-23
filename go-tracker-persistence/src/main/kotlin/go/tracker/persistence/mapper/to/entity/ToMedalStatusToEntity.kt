package go.tracker.persistence.mapper.to.entity

import brave.internal.collect.UnsafeArrayMap.Mapper
import go.tracker.models.trainer.TrainerMedalStatus
import go.tracker.persistence.entity.trainer.MedalStatusEntity
import java.time.LocalDateTime

val ToMedalStatusToEntity =
    Mapper<TrainerMedalStatus, MedalStatusEntity> { trainerMedalStatus ->
        MedalStatusEntity().apply {
            medal = trainerMedalStatus.medal
            value = trainerMedalStatus.value
            entryDate = LocalDateTime.now()
        }

    }