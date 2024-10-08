package go.tracker.api.config

import go.tracker.api.config.message.MessageDefault
import go.tracker.domain.common.MessageCode
import go.tracker.models.exceptions.*
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@ControllerAdvice
class GlobalExceptionHandler(
    private val source: MessageSource
) {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleConstraintViolationException(ex: MethodArgumentNotValidException) =
        ResponseEntity(
            ex.bindingResult.allErrors.map { error ->
                MessageDefault(
                    error.defaultMessage.toString(),
                    arrayOf(
                        source.getMessage(
                            MessageCode.REQUIRED_FIELD,
                            arrayOf((error as FieldError).field),
                            Locale.getDefault()
                        )
                    ),
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

    @ExceptionHandler(InvalidTrainerStatusException::class)
    fun handleInvalidTrainerStatusException(ex: InvalidTrainerStatusException): ResponseEntity<ApiResponse> {
        val response = ApiResponse().fromSet(setOf(MessageCode.INVALID_TRAINER_STATUS, ex.field))
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(InvalidMedalStatusException::class)
    fun handleInvalidMedalStatusException(ex: InvalidMedalStatusException): ResponseEntity<ApiResponse> {
        val response = ApiResponse().fromSet(setOf(MessageCode.INVALID_MEDAL_STATUS, ex.message.toString()))
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(TrainerNotFoundException::class)
    fun handleTrainerNotFoundException(ex: TrainerNotFoundException): ResponseEntity<ApiResponse> {
        val response = ApiResponse().fromSet(setOf(MessageCode.TRAINER_NOT_FOUND, ex.message.toString()))
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(MedalStatusNotFoundException::class)
    fun handleTrainerMedalStatusNotFoundException(ex: MedalStatusNotFoundException): ResponseEntity<ApiResponse> {
        val response = ApiResponse().fromSet(setOf(MessageCode.TRAINER_MEDAL_STATUS_NOT_FOUND, ex.message.toString()))
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(TrainerGoalsNotFoundException::class)
    fun handleTrainerGoalsNotFoundException(ex: TrainerGoalsNotFoundException): ResponseEntity<ApiResponse> {
        val response = ApiResponse().fromSet(setOf(MessageCode.TRAINER_GOALS_NOT_FOUND, ex.message.toString()))
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

    private fun map(code: String, args: Array<String>?) = setOf(
        code, source.getMessage(code, args, Locale.getDefault())
    )
}
