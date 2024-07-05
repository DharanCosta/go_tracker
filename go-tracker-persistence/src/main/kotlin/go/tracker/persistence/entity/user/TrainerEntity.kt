package go.tracker.persistence.entity.user

import go.tracker.persistence.entity.GoalsEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.PrimaryKeyJoinColumn
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(name = "User")
@Table(name = "USER")
@PrimaryKeyJoinColumn(name = "IDT_TRAINER", referencedColumnName = "IDT_USER")
class TrainerEntity(
    creationDate: LocalDateTime = LocalDateTime.now(),
    updateDate: LocalDateTime = LocalDateTime.now()
): UserEntity(
    creationDate = creationDate,
    updateDate = updateDate
) {

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

    @OneToMany
    var goals: List<GoalsEntity>?=  null
}
