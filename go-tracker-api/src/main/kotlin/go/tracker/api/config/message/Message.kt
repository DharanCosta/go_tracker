package go.tracker.api.config.message

import java.io.Serializable

interface Message : Serializable {
    fun getCode(): String
    fun getMessage(): Array<Any>?
    fun getContext(): Map<String,Any>?
}
