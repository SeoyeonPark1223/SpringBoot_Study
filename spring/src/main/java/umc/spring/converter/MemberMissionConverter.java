package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.AddMemberMissionDTO toAddMemberMissionDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.AddMemberMissionDTO.builder()
                .memberMissionId(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .storeId(memberMission.getMission().getStore().getId())
                .reward(memberMission.getMission().getReward())
                .deadline(memberMission.getMission().getDeadline())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .build();
    }

    // build MemberMission; mapping entity
    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionPreviewDTO toMemberMissionPreviewDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionPreviewDTO.builder()
                .missionStatus(memberMission.getStatus())
                .reward(memberMission.getMission().getReward())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .storeName(memberMission.getMission().getStore().getName())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionListDTO toMemberMissionListDTO(Page<MemberMission> missionList) {
        List<MemberMissionResponseDTO.MemberMissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(MemberMissionConverter::toMemberMissionPreviewDTO).collect(Collectors.toList());

        return MemberMissionResponseDTO.MemberMissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewDTOList.size())
                .missionList(missionPreviewDTOList)
                .build();
    }
}
