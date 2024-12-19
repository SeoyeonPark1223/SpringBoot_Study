package umc.hongik_hospital.service.patientService;

import umc.hongik_hospital.domain.Patient;
import umc.hongik_hospital.web.dto.PatientRequestDTO;

public interface PatientCommandService {
    Patient joinPatient(PatientRequestDTO.JoinDTO request);
}
