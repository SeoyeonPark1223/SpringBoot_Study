package umc.spring.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class reviewDTO {
        Long memberId;
        String body;
        Float score;
    }
}
