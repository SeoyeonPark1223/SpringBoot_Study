package umc.hongik_hospital.converter;

import umc.hongik_hospital.domain.Patient;
import umc.hongik_hospital.domain.enums.Gender;
import umc.hongik_hospital.web.dto.PatientRequestDTO;
import umc.hongik_hospital.web.dto.PatientResponseDTO;

public class PatientConverter {
    public static Patient toPatient(PatientRequestDTO.JoinDTO request) {
        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Patient.builder()
                .pName(request.getName())
                .age(request.getAge())
                .gender(gender)
                .build();
    }

    public static PatientResponseDTO.JoinResultDTO toJoinResultDTO(Patient patient) {
        return PatientResponseDTO.JoinResultDTO.builder()
                .patientId(patient.getId())
                .createdAt(patient.getCreatedAt())
                .updatedAt(patient.getUpdatedAt())
                .build();
    }
}
