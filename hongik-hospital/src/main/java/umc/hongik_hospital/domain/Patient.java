package umc.hongik_hospital.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.hongik_hospital.domain.common.BaseEntity;
import umc.hongik_hospital.domain.enums.Gender;
import umc.hongik_hospital.domain.mapping.Reservation;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Patient extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String pName;

    private int pAge;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'MALE'")
    private Gender gender;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Reservation> reservationList = new ArrayList<>();
}
