package ru.vsu.cs.buchnev.hospital.item.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;
import ru.vsu.cs.buchnev.hospital.api.model.DoctorDto;

import java.util.List;
import java.util.UUID;

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

    @ManyToMany
    @JoinTable(name = "doctor_department",
            joinColumns = {@JoinColumn(name = "department_id")},
            inverseJoinColumns = {@JoinColumn(name = "doctor_id")})
    private List<DoctorItem> doctors; ;


}
