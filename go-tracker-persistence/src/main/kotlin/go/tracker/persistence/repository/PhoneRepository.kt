package go.tracker.persistence.repository

import go.tracker.persistence.entity.PhoneEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhoneRepository : JpaRepository<PhoneEntity, Long> {}