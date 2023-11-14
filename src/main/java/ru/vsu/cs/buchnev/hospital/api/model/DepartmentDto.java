package ru.vsu.cs.buchnev.hospital.api.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {
    private Integer id;
    private String name;
    private String address;
    private List<DoctorDto> doctors;
}
