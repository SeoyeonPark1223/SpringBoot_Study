package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.validation.annotation.ExistStore;

import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResponseDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    public static class AddMemberMissionDTO {
        Long memberMissionId;
        Long memberId;
        Long missionId;
        Long storeId;
        Integer reward;
        LocalDateTime deadline;
        String missionSpec;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MemberMissionPreviewDTO {
        MissionStatus missionStatus;
        Integer reward;
        String missionSpec;
        String storeName;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberMissionListDTO {
        @ExistStore
        List<MemberMissionPreviewDTO> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}
