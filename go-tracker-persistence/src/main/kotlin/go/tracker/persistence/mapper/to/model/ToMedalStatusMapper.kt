package go.tracker.persistence.mapper.to.model

import go.tracker.commons.mapper.Mapper
import go.tracker.models.trainer.TrainerMedalStatus
import go.tracker.persistence.entity.trainer.MedalStatusEntity

val ToMedalStatusMapper =
    Mapper<MedalStatusEntity, TrainerMedalStatus> { entity ->
        TrainerMedalStatus().apply {
            medal = entity.medal
            value = entity.value
            datCreated = entity.entryDate
        }
    }