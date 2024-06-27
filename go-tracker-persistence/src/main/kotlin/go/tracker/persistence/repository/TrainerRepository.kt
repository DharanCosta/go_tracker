package go.tracker.persistence.repository

import go.tracker.persistence.entity.TrainerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrainerRepository: JpaRepository<TrainerEntity, Long> {}