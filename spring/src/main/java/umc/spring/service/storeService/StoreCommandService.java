package umc.spring.service.storeService;

import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.ReviewRequestDTO;

public interface StoreCommandService {
    Review writeReview(ReviewRequestDTO.reviewDTO request, Long storeId);
    MemberMission addMemberMission(MemberMissionRequestDTO.MemberMissionDTO request, Long storeId, Long missionId);
}
