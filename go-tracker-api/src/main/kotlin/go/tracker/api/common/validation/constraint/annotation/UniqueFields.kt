package go.tracker.api.common.validation.constraint.annotation

import go.tracker.api.common.validation.constraint.validator.UniqueDataValidator
import go.tracker.domain.common.MessageCode
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Constraint(validatedBy = [UniqueDataValidator::class])
@Retention(AnnotationRetention.RUNTIME)
annotation class UniqueFields(
    val message: String = MessageCode.UNIQUE_FIELD_VIOLATION,
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val required: Boolean = false
)
