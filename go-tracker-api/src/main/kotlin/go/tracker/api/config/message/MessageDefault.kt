package go.tracker.api.config.message

import java.io.Serializable

class MessageDefault(
    private val code: String = "",
    private val message: Array<Any>? = null,
    private val context: Map<String, Any>? = null
) : Message, Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    override fun getCode(): String {
        return code
    }

    override fun getMessage(): Array<Any>? {
        return message
    }

    override fun getContext(): Map<String, Any>? {
        return context
    }
}
