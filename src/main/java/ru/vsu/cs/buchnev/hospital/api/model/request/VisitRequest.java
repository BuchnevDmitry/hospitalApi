package ru.vsu.cs.buchnev.hospital.api.model.request;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitRequest {
    private Date dateVisit;
    private int doctorId;
    private int patientId;
}
