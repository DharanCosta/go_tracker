package go.tracker.persistence.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(name = "User")
@Table(name = "USER")
class UserEntity(
    creationDateTime: LocalDateTime = LocalDateTime.now(),
    updateTime: LocalDateTime = LocalDateTime.now()
): AuditableEntity(creationDateTime,updateTime) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_USER")
    var id: Long? = null

    @Column(name = "EMAIL", columnDefinition = "VARCHAR2(50)", nullable = false, unique = true)
    var email: String = ""

    @Column(name = "PASSWORD", columnDefinition = "VARCHAR2(50)", nullable = false)
    var password: String = ""

    @Column(name = "NAME", columnDefinition = "VARCHAR2(150)", nullable = false)
    var name: String = ""

    @Column(name = "BIRTH_DATE", columnDefinition = "DATE", nullable = false)
    var birthdate: LocalDate? = LocalDate.now()

    var address: AddressEntity? = null

    var phone: PhoneEntity? = null

}