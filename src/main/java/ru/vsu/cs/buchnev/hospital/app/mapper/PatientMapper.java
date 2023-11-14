package ru.vsu.cs.buchnev.hospital.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.buchnev.hospital.api.model.PatientDto;
import ru.vsu.cs.buchnev.hospital.item.model.PatientItem;

import java.util.List;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);
    PatientDto toDto(PatientItem item);
    List<PatientDto> toDto(List<PatientItem> items);
}
