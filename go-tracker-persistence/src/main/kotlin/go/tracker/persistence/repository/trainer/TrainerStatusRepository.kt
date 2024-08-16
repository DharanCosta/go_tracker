package go.tracker.persistence.repository.trainer

import go.tracker.persistence.entity.trainer.TrainerStatusEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrainerStatusRepository: JpaRepository<TrainerStatusEntity, Long> {
    fun findTopByTrainerIdOrderByEntryDateDesc(trainerId: Long): TrainerStatusEntity?
}