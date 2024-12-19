package umc.hongik_hospital.service.hospitalService;

import org.springframework.data.domain.Page;
import umc.hongik_hospital.domain.Hospital;

public interface HospitalQueryService {
    Page<Hospital> getHospitalList(Integer page);
}
