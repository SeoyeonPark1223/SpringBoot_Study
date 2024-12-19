package umc.hongik_hospital.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.hongik_hospital.domain.Patient;
import umc.hongik_hospital.domain.Specialist;
import umc.hongik_hospital.domain.common.BaseEntity;
import umc.hongik_hospital.domain.enums.RevStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Reservation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'ACTIVE'")
    private RevStatus revStatus;

    @Column(nullable = false, length = 100)
    private String medicalRecord;

    private Long price;

    private LocalDateTime reservationTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
