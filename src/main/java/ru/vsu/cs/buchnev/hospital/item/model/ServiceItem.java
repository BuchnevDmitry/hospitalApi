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
@Table(name = "service")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceItem {
    @Id
    @Generated
    private Integer id;
    private String name;
    private String description;
    @Column(name = "date_rendering")
    private Date dateRendering;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    private DepartmentItem department;

    @ManyToMany
    @JoinTable(name = "service_visit",
            joinColumns = {@JoinColumn(name = "service_id")},
            inverseJoinColumns = {@JoinColumn(name = "visit_id")})
    private List<VisitItem> visits;
}
