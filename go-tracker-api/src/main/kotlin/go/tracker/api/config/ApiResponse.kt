package go.tracker.api.config

data class ApiResponse(var code: String? = null, var message: String? = null) {
    fun fromSet(set: Set<String>) = this.apply {
        code = set.elementAt(0)
        message = set.elementAt(1)
    }
}