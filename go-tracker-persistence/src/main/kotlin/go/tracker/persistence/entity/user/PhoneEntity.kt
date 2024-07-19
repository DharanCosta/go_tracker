package go.tracker.persistence.entity.user

import jakarta.persistence.*

@Entity(name = "Phone")
@Table(name = "PHONE")
class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_PHONE")
    var id: Long? = null

    @Column(name = "NUMBER", columnDefinition = "VARCHAR2(20)", nullable = false, unique = true)
    var number: String? = null

    @Column(name = "COUNTRY_CODE", columnDefinition = "VARCHAR2(20)", nullable = true)
    var countryCode: String? = null

    @Column(name = "VALIDATED", columnDefinition = "BOOLEAN", nullable = false)
    var validated: Boolean? = false

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDT_USER", nullable = false, referencedColumnName = "IDT_USER")
    var user: AppUserEntity? = null
}
