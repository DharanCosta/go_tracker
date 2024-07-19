package go.tracker.api.common.validation.constraint.annotation

import go.tracker.api.common.validation.constraint.validator.NameValidator
import go.tracker.domain.common.MessageCode
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [NameValidator::class])
@Retention(AnnotationRetention.RUNTIME)
annotation class ValidName (
    val message: String = MessageCode.INVALID_FIELD,
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val required: Boolean = false
)