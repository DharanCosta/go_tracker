package go.tracker.persistence.repository

import go.tracker.persistence.entity.GoalsEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GoalsRepository: JpaRepository<GoalsEntity, Long> {}