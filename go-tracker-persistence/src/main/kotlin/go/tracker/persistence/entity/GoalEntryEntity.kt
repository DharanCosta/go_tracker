package go.tracker.persistence.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(name ="GoalEntry")
@Table(name = "GOAL_ENTRY")
class GoalEntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_GOAL_ENTRY")
    var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDT_GOAL", columnDefinition = "INTEGER", nullable = false)
    var goal: GoalsEntity? = null

    @Column(name = "ENTRY_VALUE", columnDefinition = "DECIMAL(19, 4)", nullable = false)
    var entry: BigDecimal? = null

    @Column(name = "ENTRY_DATE", columnDefinition = "DATE", nullable = false)
    var date: LocalDateTime? = LocalDateTime.now()
}