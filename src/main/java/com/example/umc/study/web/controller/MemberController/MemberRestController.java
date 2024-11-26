package com.example.umc.study.web.controller.MemberController;

import com.example.umc.study.ApiResponse.ApiResponse;
import com.example.umc.study.converter.MemberConverter;
import com.example.umc.study.converter.MissionConverter;
import com.example.umc.study.converter.StoreConverter;
import com.example.umc.study.domain.Member;
import com.example.umc.study.domain.Mission;
import com.example.umc.study.domain.Review;
import com.example.umc.study.domain.mapping.MemberMission;
import com.example.umc.study.service.MemberService.MemberCommandService;
import com.example.umc.study.service.StoreService.StoreQueryService;
import com.example.umc.study.validation.annotation.CheckPage;
import com.example.umc.study.validation.annotation.ExistStores;
import com.example.umc.study.web.dto.MemberDto.MemberRequestDTO;
import com.example.umc.study.web.dto.MemberDto.MemberResponseDTO;
import com.example.umc.study.web.dto.MissionDto.MissionResponseDTO;
import com.example.umc.study.web.dto.StoreDto.StoreResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final StoreQueryService storeQueryService;


    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    //내가 작성한 리뷰 목록 조회
    @GetMapping("{memberId}/reviews")
    @Operation(summary = "내가 쓴 리뷰 목록 조회 API",description = "내가 쓴 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버 아이디, path variable 입니다")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getMemberReviewList(
            @ExistStores @PathVariable(name = "memberId") Long memberId,
            @CheckPage @RequestParam(name = "page") Integer page){

        Page<Review> reviewList = storeQueryService.getMemberReviewList(memberId, page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }

    //내가 진행중인 미션 목록 조회
    @GetMapping("{memberId}/missions")
    @Operation(summary = "내가 진행중인 미션 목록 조회 API",description = "내가 진행중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버 아이디, path variable 입니다")
    })
    public ApiResponse<MissionResponseDTO.MemberMissionPreViewListDTO> getMemberMissionList(
            @PathVariable(name = "memberId") Long memberId,
            @CheckPage @RequestParam(name = "page") Integer page){
        page = page -1;
        Page<MemberMission> missionList=storeQueryService.getMemberMissionList(memberId,page);
        System.out.println("page"+page);
        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTO(missionList));
    }
}
