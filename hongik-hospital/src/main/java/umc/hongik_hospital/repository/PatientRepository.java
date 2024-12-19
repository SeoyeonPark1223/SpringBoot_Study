package umc.hongik_hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hongik_hospital.domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
//    Boolean findByName(String name);
}
