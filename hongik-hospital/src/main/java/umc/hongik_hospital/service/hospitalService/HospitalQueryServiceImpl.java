package umc.hongik_hospital.service.hospitalService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.hongik_hospital.domain.Hospital;
import umc.hongik_hospital.repository.HospitalRepository;

@Service
@RequiredArgsConstructor
public class HospitalQueryServiceImpl implements HospitalQueryService {
    private final HospitalRepository hospitalRepository;

    @Override
    public Page<Hospital> getHospitalList(Integer page) {
        Page<Hospital> hospitalPage = hospitalRepository.findAll(PageRequest.of(page, 10));

        return hospitalPage;
    }
}
