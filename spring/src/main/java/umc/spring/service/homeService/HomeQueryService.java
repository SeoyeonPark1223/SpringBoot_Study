package umc.spring.service.homeService;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;

public interface HomeQueryService {
    @Transactional
    Page<Review> getReviewList(Long memberId, Integer page);
}
