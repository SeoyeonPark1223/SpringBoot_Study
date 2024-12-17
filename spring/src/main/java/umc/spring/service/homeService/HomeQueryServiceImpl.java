package umc.spring.service.homeService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class HomeQueryServiceImpl implements HomeQueryService {
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<Review> storePage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return storePage;
    }
}
