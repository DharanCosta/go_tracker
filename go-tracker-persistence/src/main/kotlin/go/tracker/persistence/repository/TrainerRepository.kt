package go.tracker.persistence.repository

import go.tracker.persistence.entity.user.TrainerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface TrainerRepository: JpaRepository<TrainerEntity, Long> {
     fun findByIgn(ign: String): Optional<TrainerEntity>

     fun findByEmail(email: String): Optional<TrainerEntity>

     fun existsByIgn(ign: String): Boolean

     fun existsByEmail(email: String): Boolean
}