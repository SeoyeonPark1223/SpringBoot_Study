package umc.hongik_hospital.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.*;
import lombok.NoArgsConstructor;
import umc.hongik_hospital.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Specialty extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String field;

    @Column(nullable = false, length = 20)
    private String phoneNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToMany(mappedBy = "specialty", cascade = CascadeType.ALL)
    private List<Specialist> specialistList = new ArrayList<>();
}
