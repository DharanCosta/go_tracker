package go.tracker.persistence.repository.user

import go.tracker.persistence.entity.user.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository: JpaRepository<AddressEntity, Long> {}