package go.tracker.api.common.validation.constraint.validator

import go.tracker.api.common.validation.constraint.annotation.ValidEnumList
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class EnumListValidator : ConstraintValidator<ValidEnumList, String> {
    private lateinit var enumValues: Set<String>

    override fun initialize(constraintAnnotation: ValidEnumList) {
        enumValues = constraintAnnotation.enumClass.java.enumConstants
            .map { it.name }
            .toSet()
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        if (value.isNullOrEmpty()) return true

        val valueList = value.split(",").map { it.trim() }

        return valueList.all { it in enumValues }
    }
}