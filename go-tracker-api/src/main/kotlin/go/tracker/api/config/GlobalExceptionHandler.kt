package go.tracker.api.config

import go.tracker.domain.common.MessageCode
import go.tracker.models.exceptions.UniqueFieldViolationException
import jakarta.validation.ConstraintViolationException
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*
import java.util.Locale.getDefault

@ControllerAdvice
class GlobalExceptionHandler(
    private val source: MessageSource
) {

//    @ExceptionHandler(NotFoundException::class)
//    fun handleNotFoundException(ex: NotFoundException): ResponseEntity<ApiResponse> {
//        val response = ApiResponse(MessageCode.REQUIRED_FIELD, ex.message ?: "Not Found")
//        return ResponseEntity(response, HttpStatus.NOT_FOUND)
//    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleConstraintViolationException(ex: MethodArgumentNotValidException) =
        ResponseEntity(
            ex.bindingResult.allErrors.map { error ->
                MessageDefault(
                    error.defaultMessage.toString(),
                    arrayOf(source.getMessage(MessageCode.REQUIRED_FIELD, arrayOf((error as FieldError).field), Locale.getDefault())),
                    mapOf(
                        Pair("field", error.field),
                        Pair("value", error.rejectedValue.toString())
                    )
                )
            },
            HttpStatus.BAD_REQUEST
        )

    @ExceptionHandler(UniqueFieldViolationException::class)
    fun handleUniqueFieldViolationException(ex: UniqueFieldViolationException): ResponseEntity<ApiResponse> {
        val response = ApiResponse().fromSet(map(MessageCode.UNIQUE_FIELD_VIOLATION, arrayOf(ex.field)))
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    private fun map(code: String, args: Array<String>?) = setOf(
        code, source.getMessage(code, args, Locale.getDefault())
    )

}
