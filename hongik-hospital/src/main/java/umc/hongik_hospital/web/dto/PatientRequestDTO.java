package umc.hongik_hospital.web.dto;

import lombok.Getter;
import umc.hongik_hospital.domain.enums.Gender;

public class PatientRequestDTO {
    @Getter
    public static class JoinDTO {
        String name;
        Integer age;
        Integer gender;
    }
}
