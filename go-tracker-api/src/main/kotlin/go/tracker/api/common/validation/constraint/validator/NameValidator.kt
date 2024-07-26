package go.tracker.api.common.validation.constraint.validator

import go.tracker.api.common.validation.constraint.annotation.ValidName
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class NameValidator: ConstraintValidator<ValidName, String> {
    private val space = "\\s"
    private val validCharacters = "a-zA-ZàèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôû ÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜ?çÇßØøÅåÆæ'"
    private val regex = "[$validCharacters]{2,}\\s[$validCharacters$space]*?[$validCharacters]{2,}[$validCharacters$space]*$"


    override fun isValid(name: String?, context: ConstraintValidatorContext?): Boolean =
        name.isNullOrBlank() || name.trim().matches(Regex(regex))
}