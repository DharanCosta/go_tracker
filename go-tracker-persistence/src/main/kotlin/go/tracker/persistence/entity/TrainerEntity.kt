package go.tracker.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity(name = "User")
@Table(name = "USER")
class TrainerEntity(): UserEntity() {

    @Column(name = "IGN", columnDefinition = "VARCHAR2(50)", nullable = false, unique = true)
    var ign: String = ""

    @Column(name = "LEVEL", columnDefinition = "INTEGER", nullable = false)
    var level: Int = 0

    @Column(name = "START_DATE", columnDefinition = "DATE", nullable = false)
    var startDate: LocalDate = LocalDate.now()

    @Column(name = "INITIAL_XP", columnDefinition = "DATE", nullable = false)
    var initialXP: Long? = null

    @Column(name = "INITIAL_CATCH", columnDefinition = "DATE", nullable = false)
    var initialCatch: Long? = null

    @Column(name= "PUBLIC", columnDefinition = "BOOLEAN", nullable = false)
    var public: Boolean? = false
}
