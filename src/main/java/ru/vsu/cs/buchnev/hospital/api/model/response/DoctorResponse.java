package ru.vsu.cs.buchnev.hospital.api.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorResponse {
    private Integer id;
    private String fio;
    private String specalization;
}
