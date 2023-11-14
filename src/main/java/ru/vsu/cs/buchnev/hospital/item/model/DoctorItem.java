package ru.vsu.cs.buchnev.hospital.item.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;

import java.util.List;
import java.util.UUID;

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

}
