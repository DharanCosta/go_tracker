package go.tracker.persistence.mapper.to.model

import go.tracker.commons.mapper.Mapper
import go.tracker.models.user.Phone
import go.tracker.persistence.entity.user.PhoneEntity

val ToPhone =
    Mapper<PhoneEntity, Phone> { phone ->
        Phone().apply {
            id = phone.id
            number = phone.number
            countryCode = phone.countryCode
            validated = phone.validated
        }
    }
