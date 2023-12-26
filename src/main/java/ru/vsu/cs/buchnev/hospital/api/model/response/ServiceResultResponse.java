package ru.vsu.cs.buchnev.hospital.api.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceResultResponse {
    private long count;
    private long summa;
}
