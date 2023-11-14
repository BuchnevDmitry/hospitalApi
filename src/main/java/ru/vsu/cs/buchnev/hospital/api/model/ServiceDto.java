package ru.vsu.cs.buchnev.hospital.api.model;

import java.util.Date;
import java.util.UUID;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceDto {
    private Integer id;
    private String name;
    private String description;
    private Date dateRendering;
    private int price;
    private DepartmentDto department;
}
