package ru.vsu.cs.buchnev.hospital.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.buchnev.hospital.api.model.ServiceDto;

import java.util.List;

@Mapper
public interface ServiceMapper {

    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);
    ServiceDto toDto(ServiceDto item);
    List<ServiceDto> toDto(List<ServiceDto> items);
}
