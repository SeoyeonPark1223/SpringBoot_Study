package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.ReviewRepository;
import umc.spring.validation.annotation.ExistStore;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Object> {

    private final ReviewRepository reviewRepository;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value instanceof Long) { // 단일 Long 값 처리
            return reviewRepository.existsById((Long) value);
        } else if (value instanceof List) { // List<Long> 처리
            return ((List<?>) value).stream()
                    .allMatch(val -> val instanceof Long && reviewRepository.existsById((Long) val));
        }
        return false; // 다른 타입은 검증 실패
    }
}
