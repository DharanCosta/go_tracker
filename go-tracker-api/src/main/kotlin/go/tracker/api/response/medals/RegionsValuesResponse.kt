package go.tracker.api.response.medals

import java.math.BigDecimal

data class RegionsValuesResponse(
    var kanto: BigDecimal? = null,
    var johto: BigDecimal? = null,
    var hoenn: BigDecimal? = null,
    var sinnoh: BigDecimal? = null,
    var unova: BigDecimal? = null,
    var kalos: BigDecimal? = null,
    var alola: BigDecimal? = null,
    var galar: BigDecimal? = null,
    var hisui: BigDecimal? = null,
    var paldea: BigDecimal? = null,
)