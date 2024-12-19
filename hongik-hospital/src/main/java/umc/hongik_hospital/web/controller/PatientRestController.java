package umc.hongik_hospital.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.hongik_hospital.apiPayload.ApiResponse;
import umc.hongik_hospital.domain.Patient;
import umc.hongik_hospital.web.dto.MemberRequestDTO;
import umc.hongik_hospital.web.dto.MemberResponseDTO;
import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class MemberRestController {

    private final PatientCommandService patientCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join (@RequestBody @Valid MemberRequestDTO.JoinDTO request) {
        Patient patient = patientCommandService.joinPatient("")
    }
}
