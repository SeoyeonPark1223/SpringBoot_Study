package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

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
}
