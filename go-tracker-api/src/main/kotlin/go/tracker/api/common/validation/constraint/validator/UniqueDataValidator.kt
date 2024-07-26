package go.tracker.api.common.validation.constraint.validator

import go.tracker.api.common.validation.constraint.annotation.UniqueFields
import go.tracker.api.request.TrainerCreateRequest
import go.tracker.domain.service.RequestValidatorService
import go.tracker.models.exceptions.UniqueFieldViolationException
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class UniqueDataValidator(
    private val requestValidatorService: RequestValidatorService
):  ConstraintValidator<UniqueFields, TrainerCreateRequest> {
    override fun isValid(
        request: TrainerCreateRequest?, context: ConstraintValidatorContext?
    ): Boolean {
        if(request?.ign != null && request.email != null) {
            if (requestValidatorService.existTrainer(request.ign!!))
                throw UniqueFieldViolationException("ign")
        if (requestValidatorService.existEmail(request.email!!))
            throw UniqueFieldViolationException("email")
        }
        return  true
    }
}
