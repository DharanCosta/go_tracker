package go.tracker.api.common.validation.constraint.annotation

import go.tracker.api.common.validation.constraint.validator.EnumListValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [EnumListValidator::class])
annotation class ValidEnumList(
    val message: String = "Invalid value(s) in the list. Allowed values are: {enumClass}",
    val enumClass: KClass<out Enum<*>>,
    val fieldName: String = "", // Optional: If you want to specify which field is being validated
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)