package go.tracker.models.trainer

import java.math.BigDecimal

data class TrainerStatus(
    var xp: BigDecimal? = null,
    var dust: BigDecimal? = null,
    var catches: BigDecimal? = null,
    var pokestops: BigDecimal? = null,
    var distance: BigDecimal? = null,
    var username: String? = null
)