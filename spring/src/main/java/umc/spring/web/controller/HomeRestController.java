package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.homeService.HomeQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.ReviewResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeRestController {

    private final HomeQueryService homeQueryService;

    @GetMapping("/reviews")
    @Operation(summary = "특정 멤버의 리뷰 목록 조회 API",description = "특정 멤버의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 memberId, page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getReviewList(@RequestParam("memberId") Long memberId, @CheckPage @RequestParam("page") Integer page) {
        // page == 1일 때 0으로 변환
        int pageNumber = (page == 1) ? 0 : page;

        Page<Review> reviewList = homeQueryService.getReviewList(memberId, pageNumber);
        return ApiResponse.onSuccess(ReviewConverter.toReviewPreviewListDTO(reviewList));
    }

    @GetMapping("/missions")
    @Operation(summary = "특정 멤버의 진행중인 미션 목록 조회 API")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<MemberMissionResponseDTO.MemberMissionListDTO> getMissionList(@RequestParam("memberId") Long memberId, @CheckPage @RequestParam("page") Integer page) {
        int pageNumber = (page == 1) ? 0 : page;

        Page<MemberMission> missionList = homeQueryService.getMissionList(memberId, pageNumber);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionListDTO(missionList));
    }
}
