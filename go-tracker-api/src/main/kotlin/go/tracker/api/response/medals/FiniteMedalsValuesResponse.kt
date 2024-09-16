package go.tracker.api.response.medals

import java.math.BigDecimal

data class FiniteMedalsValuesResponse(
    var unown: BigDecimal? = null,
    var megaEvolutionGuru: BigDecimal? = null,
    var vivillon: BigDecimal? = null,
)