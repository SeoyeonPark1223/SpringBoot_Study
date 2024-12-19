package umc.hongik_hospital.web.dto;

import lombok.Getter;
import umc.hongik_hospital.domain.enums.Gender;

public class MemberRequestDTO {
    @Getter
    public static class JoinDTO {
        String name;
        Integer age;
        Gender gender;
    }
}
