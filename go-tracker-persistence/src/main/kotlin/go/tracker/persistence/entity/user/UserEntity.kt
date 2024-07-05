package go.tracker.persistence.entity.user

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(name = "User")
@Table(name = "USER")
@Inheritance(strategy = InheritanceType.JOINED)
class UserEntity(
    creationDate: LocalDateTime = LocalDateTime.now(),
    updateDate: LocalDateTime = LocalDateTime.now()
): AuditableEntity(creationDate, updateDate) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_USER")
    var id: Long? = null

    @Column(name = "EMAIL", columnDefinition = "VARCHAR2(100)", nullable = false, unique = true)
    var email: String = ""

    @Column(name = "PASSWORD", columnDefinition = "VARCHAR2(50)", nullable = false)
    var password: String = ""

    @Column(name = "NAME", columnDefinition = "VARCHAR2(150)", nullable = false)
    var name: String = ""

    @Column(name = "BIRTH_DATE", columnDefinition = "DATE", nullable = false)
    var birthdate: LocalDate? = LocalDate.now()

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL])
    var address: AddressEntity? = null

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL])
    var phone: PhoneEntity? = null
}