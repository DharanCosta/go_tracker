package go.tracker.persistence.mapper.to.model

import go.tracker.commons.mapper.Mapper
import go.tracker.models.user.Address
import go.tracker.persistence.entity.user.AddressEntity

val ToAddress  =
    Mapper<AddressEntity, Address> { address ->
    Address().apply {
        id = address.id
        country = address.country
        state = address.state
        city = address.city
        coordinates = address.coordinates
    }
}
