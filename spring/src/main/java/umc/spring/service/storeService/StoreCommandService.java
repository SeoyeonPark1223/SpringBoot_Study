package umc.spring.service.storeService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;

public interface StoreCommandService {
    Review writeReview(ReviewRequestDTO.reviewDTO request, Long storeId);
}
