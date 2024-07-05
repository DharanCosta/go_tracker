package models.user

import java.time.LocalDate

abstract class User {
    var id: Long? = null
    var email: String? = ""
    var password: String? = ""
    var name: String? = ""
    var birthDate: LocalDate? = LocalDate.now()
    var address: Address? = null
    var phone: Phone? = null
}
