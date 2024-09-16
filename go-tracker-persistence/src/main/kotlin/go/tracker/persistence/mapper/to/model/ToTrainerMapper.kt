package go.tracker.persistence.mapper.to.model

import go.tracker.commons.mapper.Mapper
import go.tracker.models.trainer.Trainer
import go.tracker.models.user.Address
import go.tracker.models.user.Phone
import go.tracker.persistence.entity.trainer.TrainerEntity

val ToTrainerMapper =
    Mapper<TrainerEntity, Trainer> { trainer ->
        Trainer().apply {
            id = trainer.id
            ign = trainer.ign
            level = trainer.level
            startDate = trainer.startDate
            initialXP = trainer.initialXP
            initialCatch = trainer.initialXP
            public = trainer.public
            email = trainer.email
            password = trainer.password
            name = trainer.name
            birthDate = trainer.birthDate
            type = trainer.type
            goals = ToTrainerGoals.map(trainer.goals)
            address = Address().apply {
                id = trainer.address?.id
                country = trainer.address?.country
                state = trainer.address?.state ?: ""
                city = trainer.address?.city ?: ""
                coordinates = trainer.address?.city ?: ""
            }
            phone = Phone().apply {
                id = trainer.phone?.id
                number = trainer.phone?.number
                countryCode = trainer.phone?.countryCode
            }
        }
    }
