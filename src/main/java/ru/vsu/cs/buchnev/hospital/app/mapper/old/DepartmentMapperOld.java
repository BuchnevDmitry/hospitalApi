package ru.vsu.cs.buchnev.hospital.app.mapper.old;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.buchnev.hospital.api.model.request.DepartmentRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.DepartmentResponse;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;

import java.util.List;

@Mapper
public interface DepartmentMapperOld {

    DepartmentMapperOld INSTANCE = Mappers.getMapper(DepartmentMapperOld.class);

    DepartmentItem mapRequestToItem(DepartmentRequest departmentRequest);
    DepartmentResponse mapToDto(DepartmentItem item);

    List<DepartmentResponse> mapToDto(List<DepartmentItem> items);
    List<DepartmentItem> mapToItem(List<DepartmentResponse> items);
    DepartmentItem mapToItem(DepartmentResponse dto);
}
