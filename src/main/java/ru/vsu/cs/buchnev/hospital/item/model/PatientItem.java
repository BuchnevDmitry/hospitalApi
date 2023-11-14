package ru.vsu.cs.buchnev.hospital.item.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "patient")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientItem {
    @Id
    @Generated
    private Integer id;
    private String fio;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;

    @OneToMany(mappedBy = "patient")
    private List<MedicalCardItem> medicalCard;


}
