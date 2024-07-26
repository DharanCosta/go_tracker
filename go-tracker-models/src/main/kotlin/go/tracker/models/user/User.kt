package go.tracker.models.user

import com.fasterxml.jackson.annotation.JsonTypeInfo
import go.tracker.models.enums.UserType
import java.time.LocalDate



@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = Trainer::class)
abstract class User {
    var id: Long? = null
    var email: String? = ""
    var password: String? = ""
    var name: String? = ""
    var birthDate: LocalDate? = LocalDate.now()
    var address: Address? = null
    var phone: Phone? = null
    var type: UserType? = UserType.TRAINER

    abstract fun isTrainer(): Boolean
}