package umc.hongik_hospital.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.hongik_hospital.validation.annotation.CheckPage;

public class PageCheckValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page == null || page <= 0) {
            return false;
        }

        // 검증을 통과한 경우, 값 조정 (1 -> 0)
        if (page == 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("페이지 번호를 0으로 변경했습니다.")
                    .addConstraintViolation();
        }

        return true;
    }
}
