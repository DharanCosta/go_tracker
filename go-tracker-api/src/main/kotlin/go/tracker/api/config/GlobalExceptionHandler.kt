package go.tracker.api.config

import go.tracker.domain.common.MessageCode
import go.tracker.models.exceptions.UniqueFieldViolationException
import org.apache.coyote.BadRequestException
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@ControllerAdvice
class GlobalExceptionHandler(
    private val source: MessageSource
) {

//    @ExceptionHandler(NotFoundException::class)
//    fun handleNotFoundException(ex: NotFoundException): ResponseEntity<ApiResponse> {
//        val response = ApiResponse(MessageCode.REQUIRED_FIELD, ex.message ?: "Not Found")
//        return ResponseEntity(response, HttpStatus.NOT_FOUND)
//    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex: BadRequestException): ResponseEntity<ApiResponse> {
        val response = ApiResponse(MessageCode.REQUIRED_FIELD, ex.message ?: "Bad Request")
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(UniqueFieldViolationException::class)
    fun handleUniqueFieldViolationException(ex: UniqueFieldViolationException): ResponseEntity<ApiResponse> {
        val response =  ApiResponse().fromSet(map(MessageCode.UNIQUE_FIELD_VIOLATION, arrayOf(ex.field)))
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    private fun map(code: String, args: Array<String>?) = setOf(
       code, source.getMessage(code, args, Locale.getDefault()))

}
