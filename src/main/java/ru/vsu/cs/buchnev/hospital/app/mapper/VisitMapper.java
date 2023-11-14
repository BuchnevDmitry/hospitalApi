package ru.vsu.cs.buchnev.hospital.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.buchnev.hospital.api.model.DoctorDto;
import ru.vsu.cs.buchnev.hospital.api.model.VisitDto;

import java.util.List;

@Mapper
public interface VisitMapper {
    VisitMapper INSTANCE = Mappers.getMapper(VisitMapper.class);
    VisitDto toDto(VisitDto item);
    List<VisitDto> toDto(List<VisitDto> items);
}
