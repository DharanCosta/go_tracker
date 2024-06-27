package go.tracker.persistence.entity

import enums.GoalType
import jakarta.persistence.*
import java.time.LocalDate

@Entity(name = "Goals")
@Table(name = "GOALS")
class GoalsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_GOAL")
    var id: Long? = null

    var trainer: TrainerEntity? = null

    @Column(name = "GOAL_TYPE", columnDefinition = "VARCHAR2(20)", nullable = false)
    var goalType: GoalType? = null

    @Column(name = "GOAL_NAME", columnDefinition = "VARCHAR2(50)", nullable = false)
    var goalName: String? = null

    @Column(name = "GOAL_VALUE", columnDefinition = "INTEGER", nullable = false)
    var goalValue: Long? = null

    @Column(name = "END_DATE", columnDefinition = "DATE", nullable = false)
    var endDate: LocalDate? = LocalDate.now()
}