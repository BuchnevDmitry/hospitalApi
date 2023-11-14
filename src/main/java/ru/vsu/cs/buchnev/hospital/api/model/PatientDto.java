package ru.vsu.cs.buchnev.hospital.api.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto {
    private Integer id;
    private String fio;
    private String phoneNumber;
    private String address;
    private List<MedicalCardDto> medicalCards;
}
