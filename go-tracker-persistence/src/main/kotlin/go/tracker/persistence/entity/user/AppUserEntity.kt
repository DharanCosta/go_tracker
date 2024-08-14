package go.tracker.persistence.entity.user

import go.tracker.models.enums.UserType
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(name = "AppUser")
@Table(name = "APP_USER")
@Inheritance(strategy = InheritanceType.JOINED)
class AppUserEntity(
    creationDate: LocalDateTime = LocalDateTime.now(),
    updateDate: LocalDateTime = LocalDateTime.now()
): AuditableEntity(creationDate, updateDate) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_USER")
    var id: Long? = null

    @Column(name = "EMAIL", columnDefinition = "VARCHAR2(100)", nullable = false, unique = true)
    var email: String? = ""

    @Column(name = "PASSWORD", columnDefinition = "VARCHAR2(50)", nullable = false)
    var password: String? = ""

    @Column(name = "NAME", columnDefinition = "VARCHAR2(150)", nullable = false)
    var name: String? = ""

    @Column(name = "BIRTH_DATE", columnDefinition = "DATE", nullable = false)
    var birthDate: LocalDate? = LocalDate.now()

    @Column(name = "ROLE", columnDefinition = "VARCHAR(10)", nullable = false)
    var type: UserType? = null

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL])
    var address: AddressEntity? = null

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL])
    var phone: PhoneEntity? = null
}