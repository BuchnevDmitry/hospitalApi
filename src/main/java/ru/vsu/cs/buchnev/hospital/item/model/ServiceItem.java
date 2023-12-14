package ru.vsu.cs.buchnev.hospital.item.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

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
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    private DepartmentItem department;
}
