package go.tracker.persistence.repository.trainer

import go.tracker.models.enums.Medals
import go.tracker.persistence.entity.trainer.MedalStatusEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface MedalStatusRepository: JpaRepository<MedalStatusEntity, Long> {

    @Query("SELECT m FROM MedalStatus m " +
            "WHERE m.entryDate = (SELECT MAX(ms.entryDate) FROM MedalStatus ms " +
            "WHERE ms.trainer = m.trainer AND ms.medal = :medal) " +
            "AND m.trainer.id = :trainerId")
    fun findLastMedalEntriesForTrainer(medal: Medals, trainerId: Long): Optional<MedalStatusEntity>
}