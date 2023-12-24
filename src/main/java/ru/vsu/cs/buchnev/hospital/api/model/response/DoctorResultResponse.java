package ru.vsu.cs.buchnev.hospital.api.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorResultResponse {
    private DoctorResponse doctor;
    private long count;
    private long summa;
}
