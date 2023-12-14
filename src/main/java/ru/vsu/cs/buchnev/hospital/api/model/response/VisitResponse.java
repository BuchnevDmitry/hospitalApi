package ru.vsu.cs.buchnev.hospital.api.model.response;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitResponse {

    private Integer id;
    private Date dateVisit;
    private DoctorResponse doctor;
    private PatientResponse patient;
    private List<ServiceResponse> services;
}
