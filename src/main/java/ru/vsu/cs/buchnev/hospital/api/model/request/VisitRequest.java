package ru.vsu.cs.buchnev.hospital.api.model.request;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitRequest {
    private LocalDate dateVisit;
    private int doctorId;
    private int patientId;
}
