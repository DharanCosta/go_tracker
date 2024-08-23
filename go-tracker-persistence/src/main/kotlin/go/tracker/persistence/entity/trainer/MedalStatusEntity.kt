package go.tracker.persistence.entity.trainer

import go.tracker.models.enums.Medals
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "MedalStatus")
@Table(name = "MEDAL_STATUS")
class MedalStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_MEDAL_STATUS")
    var id: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "NAM_MEDAL", columnDefinition = "VARCHAR50", nullable = false)
    var medal: Medals? = null

    @Column(name = "MEDAL_VALUE", columnDefinition = "INTEGER", nullable = false)
    var value: Long? = null

    @Column(name = "DAT_CREATED", columnDefinition = "DATE", nullable = false )
    var entryDate: LocalDateTime? = LocalDateTime.now()

    @ManyToOne
    @JoinColumn(name = "IDT_TRAINER", columnDefinition = "INTEGER", nullable = false)
    var trainer : TrainerEntity? =  null
}