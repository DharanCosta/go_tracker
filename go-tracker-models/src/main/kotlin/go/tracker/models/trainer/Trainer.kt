package go.tracker.models.trainer

import go.tracker.models.user.User
import java.time.LocalDate

data class Trainer (
    var ign: String? = "",
    var level: Int? = 1,
    var startDate: LocalDate = LocalDate.now(),
    var initialXP: Long? = null,
    var initialCatch: Long? = null,
    var public: Boolean? = false
//    var goals: List<GoalsEntity>?=  null
) : User() {
    override fun isTrainer(): Boolean  = true
}