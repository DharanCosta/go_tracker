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

    @Column(name = "DDD", columnDefinition = "INTEGER", nullable = true)
    var ddd: Int? = null

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDT_USER", nullable = false, referencedColumnName = "IDT_USER")
    var user: AppUserEntity? = null
}
