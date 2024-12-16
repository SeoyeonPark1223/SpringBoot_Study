package umc.spring.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.exception.handler.ExceptionHandler;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.ReviewRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public Review writeReview(ReviewRequestDTO.reviewDTO request, Long storeId) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new ExceptionHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store =  storeRepository.findById(storeId)
                .orElseThrow(() -> new ExceptionHandler((ErrorStatus.STORE_NOT_FOUND)));
        Review review = ReviewConverter.toReview(request, member, store);

        store.addReviewList(review);
        store.updateScore(review.getScore());

        member.addReviewList(review);

        return review;
    }

    @Override
    @Transactional
    public MemberMission addMemberMission(MemberMissionRequestDTO.MemberMissionDTO request, Long storeId, Long missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new ExceptionHandler(ErrorStatus.MISSION_NOT_FOUND));
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new ExceptionHandler(ErrorStatus.MEMBER_NOT_FOUND));
        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission);

        List<MemberMission> memberMissionList = memberMissionRepository.findByMemberIdAndMissionId(member.getId(), mission.getId());
        if(!memberMissionList.isEmpty()){
            throw new ExceptionHandler(ErrorStatus.MISSION_IN_PROGRESS);
        }

        member.addMemberMissionList(memberMission);
        mission.addMemberMissionList(memberMission);

        return memberMission;
    }
}
