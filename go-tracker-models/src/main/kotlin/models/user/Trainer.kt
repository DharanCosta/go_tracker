package models.user

import java.time.LocalDate

data class Trainer (
    var ign: String = "",
    var level: Int = 0,
    var startDate: LocalDate = LocalDate.now(),
    var initialXP: Long? = null,
    var initialCatch: Long? = null,
    var public: Boolean? = false
//    var goals: List<GoalsEntity>?=  null
)