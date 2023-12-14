package ru.vsu.cs.buchnev.hospital.api.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceRequest {
    private String name;
    private String description;
    private int price;
    private int departmentId;
}
