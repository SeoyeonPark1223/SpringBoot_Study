package umc.hongik_hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hongik_hospital.domain.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
