package ru.vsu.cs.buchnev.hospital.item.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Generated;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "department")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalCardItem {
    @Id
    @Generated
    private Integer id;
    @Column(name = "date_create")
    private Date dateСreate;
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    private PatientItem patient;
}
