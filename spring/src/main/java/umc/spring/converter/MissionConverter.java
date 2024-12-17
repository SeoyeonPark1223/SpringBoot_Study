package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {
    public static MissionResponseDTO.MissionDTO toMissionDTO(Mission mission) {
        return MissionResponseDTO.MissionDTO.builder()
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .storeName(mission.getStore().getName())
                .build();
    }

    public static MissionResponseDTO.MissionListDTO toMissionListDTO(Page<Mission> missionList) {
        List<MissionResponseDTO.MissionDTO> missionDTOList = missionList.stream()
                .map(MissionConverter::toMissionDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionListDTO.builder()
                .missionList(missionDTOList)
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionDTOList.size())
                .build();
    }
}