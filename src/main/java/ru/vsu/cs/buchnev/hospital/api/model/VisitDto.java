package ru.vsu.cs.buchnev.hospital.api.model;

import lombok.*;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitDto {

    private Integer id;
    private Date dateVisit;
    private DoctorDto doctor;
    private PatientDto patient;
}
