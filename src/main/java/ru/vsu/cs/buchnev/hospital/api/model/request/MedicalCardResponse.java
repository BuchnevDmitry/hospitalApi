package ru.vsu.cs.buchnev.hospital.api.model.request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalCardResponse {
    private Date dateСreate;
    private Boolean status;
}
