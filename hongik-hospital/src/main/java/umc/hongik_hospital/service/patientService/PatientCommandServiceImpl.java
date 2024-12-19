package umc.hongik_hospital.service.patientService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.hongik_hospital.apiPayload.code.status.ErrorStatus;
import umc.hongik_hospital.apiPayload.exception.handler.ExceptionHandler;
import umc.hongik_hospital.converter.PatientConverter;
import umc.hongik_hospital.domain.Patient;
import umc.hongik_hospital.repository.PatientRepository;
import umc.hongik_hospital.web.dto.PatientRequestDTO;

@Service
@RequiredArgsConstructor
public class PatientCommandServiceImpl implements PatientCommandService {

    private final PatientRepository patientRepository;

    @Override
    @Transactional
    public Patient joinPatient(PatientRequestDTO.JoinDTO request) {
        Patient newPatient = PatientConverter.toPatient(request);

        return patientRepository.save(newPatient);
    }
}
