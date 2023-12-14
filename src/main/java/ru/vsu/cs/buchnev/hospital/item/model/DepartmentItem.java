package ru.vsu.cs.buchnev.hospital.item.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;

import java.util.List;

@Entity
@Table(name = "department")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentItem {

    @Id
    @Generated
    private Integer id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "department")
    private List<DoctorItem> doctors;

    @OneToMany(mappedBy = "department")
    private List<ServiceItem> services;


}
