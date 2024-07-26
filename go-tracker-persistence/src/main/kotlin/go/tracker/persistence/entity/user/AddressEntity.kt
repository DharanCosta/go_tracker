package go.tracker.persistence.entity.user

import jakarta.persistence.*

@Entity(name = "Address")
@Table(name = "ADDRESS")
class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_ADDRESS")
    var id: Long? = null

    @Column(name = "COUNTRY", columnDefinition = "VARCHAR(50)", nullable = false)
    var country: String? = ""

    @Column(name = "STATE", columnDefinition = "VARCHAR2(100)", nullable = false)
    var state: String = ""

    @Column(name = "CITY", columnDefinition = "VARCHAR2(100)", nullable = false)
    var city: String = ""

    @Column(name = "COORDINATES", columnDefinition = "VARCHAR2(20)", nullable = false)
    var coordinates: String = ""

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDT_USER", nullable = false, referencedColumnName = "IDT_USER")
    var user: AppUserEntity? = null
}
