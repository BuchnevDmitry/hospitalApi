package ru.vsu.cs.buchnev.hospital.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.buchnev.hospital.api.model.request.PatientRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.PatientResponse;
import ru.vsu.cs.buchnev.hospital.item.model.PatientItem;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PatientMapper {
    public abstract PatientResponse mapToDto(PatientItem item);
    public abstract List<PatientResponse> mapToDto(List<PatientItem> items);
    public abstract List<PatientItem> mapToItem(List<PatientResponse> items);
    public abstract PatientItem mapToItem(PatientResponse dto);
    public abstract PatientItem mapRequestToItem(PatientRequest patientRequest);
}
