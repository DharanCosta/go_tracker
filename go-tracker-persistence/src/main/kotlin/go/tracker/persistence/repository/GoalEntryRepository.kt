package go.tracker.persistence.repository

import go.tracker.persistence.entity.GoalEntryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GoalEntryRepository: JpaRepository<GoalEntryEntity, Long> {}