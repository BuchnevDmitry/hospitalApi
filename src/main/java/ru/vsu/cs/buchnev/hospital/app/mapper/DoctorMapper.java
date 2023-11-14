package ru.vsu.cs.buchnev.hospital.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.buchnev.hospital.api.model.DoctorDto;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;

import java.util.List;

@Mapper
public interface DoctorMapper {

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);
    DoctorDto toDto(DoctorItem item);

    List<DoctorDto> toDto(List<DoctorItem> items);
}
