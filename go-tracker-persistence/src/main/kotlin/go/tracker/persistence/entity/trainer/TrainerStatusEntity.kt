package go.tracker.persistence.entity.trainer

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(name = "TrainerStatus")
@Table(name = "TRAINER_STATUS")
class TrainerStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_TRAINER_STATUS")
    var id: Long? = null

    @Column(name = "XP", columnDefinition = "DECIMAL(19, 4)", nullable = false)
    var xp: BigDecimal? = null

    @Column(name = "DUST", columnDefinition = "DECIMAL(19, 4)", nullable = false)
    var dust: BigDecimal? = null

    @Column(name = "DAT_CREATED", columnDefinition = "DATE", nullable = false)
    var entryDate: LocalDateTime? = LocalDateTime.now()

    @ManyToOne
    @JoinColumn(name = "IDT_TRAINER", columnDefinition = "INTEGER", nullable = false)
    var trainer: TrainerEntity? = null
}