package go.tracker.persistence.mapper.to.model

import brave.internal.collect.UnsafeArrayMap.Mapper
import go.tracker.models.user.Trainer
import go.tracker.persistence.entity.user.TrainerEntity

val ToTrainer =
    Mapper<TrainerEntity, Trainer> { trainerEntity ->
        Trainer().apply {
            id = trainerEntity.id
            ign = trainerEntity.ign
            public = trainerEntity.public
            level = trainerEntity.level
            initialCatch = trainerEntity.initialCatch
            initialXP = trainerEntity.initialXP
            startDate = trainerEntity.startDate
            birthDate = trainerEntity.birthDate
            name = trainerEntity.name
            address = trainerEntity.address?.let { ToAddress.map(it) }
            phone = trainerEntity.phone?.let { ToPhone.map(it) }
        }
    }
