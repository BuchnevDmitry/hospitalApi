package ru.vsu.cs.buchnev.hospital.api.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorRequest {
    private String fio;
    private String specalization;
    private int departmentId;
}
