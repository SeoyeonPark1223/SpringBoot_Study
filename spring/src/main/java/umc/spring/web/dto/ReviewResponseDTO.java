package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class ReviewResponseDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    public static class WriteReviewDTO {
        Long reviewId;
        Long memberId;
        Long storeId;
        Float score;
        String body;
    }
}
