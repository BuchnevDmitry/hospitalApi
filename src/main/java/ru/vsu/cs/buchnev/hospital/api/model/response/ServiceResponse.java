package ru.vsu.cs.buchnev.hospital.api.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceResponse {
    private Integer id;
    private String name;
    private String description;
    private int price;
}
