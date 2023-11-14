package ru.vsu.cs.buchnev.hospital.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.buchnev.hospital.api.model.DepartmentDto;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto mapToDto(DepartmentItem item);

    List<DepartmentDto> mapToDto(List<DepartmentItem> items);
    List<DepartmentItem> mapToItem(List<DepartmentDto> items);
    DepartmentItem mapToItem(DepartmentDto dto);
}
