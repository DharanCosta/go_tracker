package go.tracker.persistence.mapper.to.entity

import go.tracker.commons.mapper.Mapper
import go.tracker.models.trainer.Trainer
import go.tracker.models.user.User
import go.tracker.persistence.entity.user.AddressEntity
import go.tracker.persistence.entity.user.PhoneEntity
import go.tracker.persistence.entity.trainer.TrainerEntity

val ToTrainerEntityMapper =
    Mapper<User, TrainerEntity> { user ->
        when (user) {
            is Trainer -> TrainerEntity().apply {
                val trainerEntity = this
                id = user.id
                ign = user.ign
                level = user.level
                startDate = user.startDate
                initialXP = user.initialXP
                initialCatch = user.initialXP
                public = user.public
                type = user.type
                email = user.email
                password = user.password
                name = user.name
                birthDate = user.birthDate
                //                goals = user.goals
                address = AddressEntity().apply {
                    country = user.address?.country
                    state = user.address?.state ?: ""
                    city = user.address?.city ?: ""
                    coordinates = user.address?.city ?: ""
                    this.user = trainerEntity
                }
                phone = PhoneEntity().apply {
                    number = user.phone?.number
                    countryCode = user.phone?.countryCode
                    validated = user.phone?.validated
                    this.user = trainerEntity
                }
            }

            else -> TrainerEntity()
        }
    }