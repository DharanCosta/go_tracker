package go.tracker.api.response

import go.tracker.models.user.Address
import go.tracker.models.user.Phone
import go.tracker.models.trainer.Trainer
import java.time.LocalDate

class TrainerProfileResponse(
    var email: String? = "",
    var password: String? = "",
    var name: String? = "",
    var birthDate: LocalDate? = LocalDate.now(),
    var address: Address? = null,
    var phone: Phone? = null,
    var ign: String? = "",
    var level: Int? = 1,
    var startDate: LocalDate = LocalDate.now(),
    var initialXP: Long? = null,
    var initialCatch: Long? = null,
    var public: Boolean? = false
) {
    fun toResponse(trainer: Trainer): TrainerProfileResponse =
        TrainerProfileResponse().apply {
            email = trainer.email
            password = trainer.password
            name = trainer.name
            birthDate = trainer.birthDate
            address = trainer.address
            phone = trainer.phone
            ign = trainer.ign
            level = trainer.level
            startDate = trainer.startDate
            initialXP = trainer.initialXP
            initialCatch = trainer.initialXP
            public = trainer.public
        }
}
