package ru.vsu.cs.buchnev.hospital.api.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDto {
    private Integer id;
    private String fio;
    private String specalization;
}
