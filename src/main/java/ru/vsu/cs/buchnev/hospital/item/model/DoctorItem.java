package ru.vsu.cs.buchnev.hospital.item.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;

@Entity
@Table(name = "doctor")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorItem {

    @Id
    @Generated
    private Integer id;
    private String fio;
    private String specalization;

    @ManyToOne(fetch = FetchType.LAZY)
    private DepartmentItem department;
}
