package go.tracker.persistence.entity

import go.tracker.models.enums.GoalType
import go.tracker.models.enums.Medals
import go.tracker.persistence.entity.trainer.TrainerEntity
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(name = "Goals")
@Table(name = "GOALS")
class GoalsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_GOAL")
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "IDT_TRAINER", columnDefinition = "INTEGER", nullable = false)
    var trainer: TrainerEntity? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "GOAL_TYPE", columnDefinition = "VARCHAR2(20)", nullable = false)
    var goalType: GoalType? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "MEDAL_NAME", columnDefinition = "VARCHAR2(50)")
    var medalName: Medals? = null

    @Column(name = "GOAL_VALUE", columnDefinition = "DECIMAL(19, 4)", nullable = false)
    var goalValue: BigDecimal? = null

    @Column(name = "START_DATE", columnDefinition = "DATE", nullable = false)
    var startDate: LocalDateTime? = LocalDateTime.now()

    @Column(name = "END_DATE", columnDefinition = "DATE", nullable = false)
    var endDate: LocalDateTime? = LocalDateTime.now()
}