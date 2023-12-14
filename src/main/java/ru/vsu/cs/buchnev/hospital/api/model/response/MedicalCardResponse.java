package ru.vsu.cs.buchnev.hospital.api.model.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalCardResponse {
    private Integer id;
    private Date dateСreate;
    private Boolean status;
}
