package ru.vsu.cs.buchnev.hospital.api.model.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentRequest {
    private String name;
    private String address;
}

//springlaud
//mongoDB
//ELK
//minIO