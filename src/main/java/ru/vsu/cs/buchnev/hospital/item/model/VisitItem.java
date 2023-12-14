package ru.vsu.cs.buchnev.hospital.item.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "visit")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VisitItem {
    @Id
    @Generated
    private Integer id;
    @Column(name = "date_visit")
    private Date dateVisit;

    @ManyToOne(fetch = FetchType.LAZY)
    private DoctorItem doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    private PatientItem patient;

    @ManyToMany
    @JoinTable(name = "service_visit",
            joinColumns = {@JoinColumn(name = "visit_id")},
            inverseJoinColumns = {@JoinColumn(name = "service_id")})
    private List<ServiceItem> services;


}
