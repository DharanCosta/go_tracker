package go.tracker.persistence.repository.trainer

import go.tracker.models.enums.Medals
import go.tracker.persistence.entity.trainer.MedalStatusEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface MedalStatusRepository: JpaRepository<MedalStatusEntity, Long> {

    @Query("SELECT m FROM MedalStatus m " +
            "WHERE m.entryDate = (SELECT MAX(ms.entryDate) FROM MedalStatus ms " +
            "WHERE ms.trainer = m.trainer AND ms.medal = :medal) " +
            "AND m.trainer.id = :trainerId")
    fun findLastMedalEntriesForTrainer(medal: Medals, trainerId: Long): Optional<MedalStatusEntity>

    @Query(value = "SELECT * FROM MEDAL_STATUS m " +
        "WHERE (m.IDT_TRAINER, m.NAM_MEDAL, m.DAT_CREATED) IN (" +
        "   SELECT ms.IDT_TRAINER, ms.NAM_MEDAL, MAX(ms.DAT_CREATED) " +
        "   FROM MEDAL_STATUS ms " +
        "   WHERE ms.IDT_TRAINER = :trainerId AND ms.NAM_MEDAL IN :medals " +
        "   GROUP BY ms.IDT_TRAINER, ms.NAM_MEDAL" +
        ")",
        nativeQuery = true)
    fun findLastMedalsEntriesForTrainer(
        @Param("medals") medals: List<String?>?,
        @Param("trainerId") trainerId: Long?
    ): List<MedalStatusEntity?>?

}