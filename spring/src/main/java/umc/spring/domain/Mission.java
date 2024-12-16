package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.MemberMission;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer reward;

    @Column(nullable = false)
    private LocalDateTime deadline;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String missionSpec;

    @ManyToOne(fetch = FetchType.LAZY) //이게 왜 ManyToOne?
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    // 새로운 mission을 리스트에 추가
    public void addMemberMissionList(MemberMission mission) {
        memberMissionList.add(mission);
    }
}
