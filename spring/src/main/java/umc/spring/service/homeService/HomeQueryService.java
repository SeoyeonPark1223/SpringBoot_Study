package umc.spring.service.homeService;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;

public interface HomeQueryService {
    Page<Review> getReviewList(Long memberId, Integer page);
    Page<MemberMission> getMissionList(Long memberId, Integer page);
}
