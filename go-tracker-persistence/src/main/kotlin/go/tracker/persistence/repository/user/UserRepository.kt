package go.tracker.persistence.repository.user

import go.tracker.persistence.entity.user.AppUserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<AppUserEntity, Long> {
    fun findByEmail(email: String): Optional<AppUserEntity>
}