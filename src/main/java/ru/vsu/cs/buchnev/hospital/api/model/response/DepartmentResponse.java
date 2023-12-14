package ru.vsu.cs.buchnev.hospital.api.model.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentResponse {
    private Integer id;
    private String name;
    private String address;
    private List<DoctorResponse> doctors;
    private List<ServiceResponse> services;
}

//springlaud
//mongoDB
//ELK
//minIO