package umc.hongik_hospital.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.hongik_hospital.apiPayload.ApiResponse;
import umc.hongik_hospital.converter.HospitalConverter;
import umc.hongik_hospital.domain.Hospital;
import umc.hongik_hospital.service.hospitalService.HospitalQueryService;
import umc.hongik_hospital.validation.annotation.CheckPage;
import umc.hongik_hospital.web.dto.HospitalResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hospitals")
public class HospitalRestController {

    private final HospitalQueryService hospitalQueryService;

    @GetMapping("/")
    @Operation(summary = "병원 목록 조회 API")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<HospitalResponseDTO.HospitalListDTO> getHospitalList(@CheckPage @RequestParam(name="page") Integer page) {
        int pageNumber = (page == null || page < 1) ? 0 : page - 1; // 페이지 값 보정
        Page<Hospital> hospitalList = hospitalQueryService.getHospitalList(pageNumber);
        return ApiResponse.onSuccess(HospitalConverter.toHospitalListDTO(hospitalList));
    }
}