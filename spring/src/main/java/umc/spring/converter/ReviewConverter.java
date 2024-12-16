package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

public class ReviewConverter {
    public static ReviewResponseDTO.WriteReviewDTO toWriteReviewDTO(Review review) {
        return ReviewResponseDTO.WriteReviewDTO.builder()
                .reviewId(review.getId())
                .memberId(review.getMember().getId())
                .storeId(review.getStore().getId())
                .score(review.getScore())
                .body(review.getBody())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.reviewDTO request, Member member, Store store) {
        return Review.builder()
                .store(store)
                .member(member)
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }
}
