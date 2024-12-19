package umc.hongik_hospital.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.hongik_hospital.apiPayload.ApiResponse;
import umc.hongik_hospital.converter.PatientConverter;
import umc.hongik_hospital.domain.Patient;
import umc.hongik_hospital.service.patientService.PatientCommandService;
import umc.hongik_hospital.web.dto.PatientRequestDTO;
import umc.hongik_hospital.web.dto.PatientResponseDTO;
import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientRestController {

    private final PatientCommandService patientCommandService;

    @PostMapping("/")
    public ApiResponse<PatientResponseDTO.JoinResultDTO> join (@RequestBody @Valid PatientRequestDTO.JoinDTO request) {
        Patient patient = patientCommandService.joinPatient(request);
        return ApiResponse.onSuccess(PatientConverter.toJoinResultDTO(patient));
    }
}
