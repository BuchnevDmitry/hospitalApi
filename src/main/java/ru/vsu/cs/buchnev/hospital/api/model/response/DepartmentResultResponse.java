package ru.vsu.cs.buchnev.hospital.api.model.response;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentResultResponse {
    private DepartmentResponse doctor;
    private long count;
    private long summa;
}
