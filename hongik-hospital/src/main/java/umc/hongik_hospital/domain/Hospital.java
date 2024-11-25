package umc.hongik_hospital.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.hongik_hospital.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Hospital extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String hName;

    @Column(nullable = false, length = 50)
    private String address;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Specialty> specialtyList = new ArrayList<>();
}
