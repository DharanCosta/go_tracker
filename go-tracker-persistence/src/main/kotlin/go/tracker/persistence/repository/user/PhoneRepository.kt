package go.tracker.persistence.repository.user

import go.tracker.persistence.entity.user.PhoneEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhoneRepository : JpaRepository<PhoneEntity, Long> {}