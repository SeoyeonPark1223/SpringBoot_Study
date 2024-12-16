package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.storeService.StoreCommandService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("{storeId}/review")
    public ApiResponse<ReviewResponseDTO.WriteReviewDTO> write(@RequestBody @Valid ReviewRequestDTO.reviewDTO request,
                                                               @PathVariable("storeId") Long storeId) {
        Review review = storeCommandService.writeReview(request, storeId);
        return ApiResponse.onSuccess(ReviewConverter.toWriteReviewDTO(review));
    }
}