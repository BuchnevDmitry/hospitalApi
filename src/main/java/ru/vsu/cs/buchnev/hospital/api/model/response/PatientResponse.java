package ru.vsu.cs.buchnev.hospital.api.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponse {
    private Integer id;
    private String fio;
    private String phoneNumber;
    private String address;
    //private MedicalCardDto medicalCard;
}
