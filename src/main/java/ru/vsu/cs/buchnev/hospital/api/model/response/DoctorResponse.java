package ru.vsu.cs.buchnev.hospital.api.model.response;

import lombok.*;
import ru.vsu.cs.buchnev.hospital.api.model.request.DepartmentRequest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorResponse {
    private Integer id;
    private String fio;
    private String specalization;
    private DepartmentResponse department;
}
