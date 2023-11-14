package ru.vsu.cs.buchnev.hospital.api.model;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalCardDto {
    private Integer id;
    private Date dateСreate;
    private Boolean status;
}
