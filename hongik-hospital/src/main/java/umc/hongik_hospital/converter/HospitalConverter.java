package umc.hongik_hospital.converter;

import org.springframework.data.domain.Page;
import umc.hongik_hospital.domain.Hospital;
import umc.hongik_hospital.web.dto.HospitalResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class HospitalConverter {
    public static HospitalResponseDTO.HospitalDTO toHospitalDTO(Hospital hospital) {
        return HospitalResponseDTO.HospitalDTO.builder()
                .name(hospital.getHName())
                .address(hospital.getAddress())
                .build();
    }

    public static HospitalResponseDTO.HospitalListDTO toHospitalListDTO(Page<Hospital> hospitalList) {
        List<HospitalResponseDTO.HospitalDTO> hospitalDTOList = hospitalList.stream()
                .map(HospitalConverter::toHospitalDTO).collect(Collectors.toList());

        return HospitalResponseDTO.HospitalListDTO.builder()
                .hospitalList(hospitalDTOList)
                .isLast(hospitalList.isLast())
                .isFirst(hospitalList.isFirst())
                .totalPage(hospitalList.getTotalPages())
                .totalElements(hospitalList.getTotalElements())
                .listSize(hospitalDTOList.size())
                .build();
    }
}
