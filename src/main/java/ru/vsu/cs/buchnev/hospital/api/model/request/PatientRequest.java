package ru.vsu.cs.buchnev.hospital.api.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequest {
    private String fio;
    private String phoneNumber;
    private String address;
}
