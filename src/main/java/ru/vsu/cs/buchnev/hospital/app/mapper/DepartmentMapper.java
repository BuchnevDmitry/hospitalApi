package ru.vsu.cs.buchnev.hospital.app.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.buchnev.hospital.api.model.request.DepartmentRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.DepartmentResponse;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DepartmentMapper {
    public abstract DepartmentItem mapRequestToItem(DepartmentRequest departmentRequest);
    public abstract DepartmentResponse mapToDto(DepartmentItem item);

    public abstract List<DepartmentResponse> mapToDto(List<DepartmentItem> items);
    public abstract List<DepartmentItem> mapToItem(List<DepartmentResponse> items);
    public abstract DepartmentItem mapToItem(DepartmentResponse dto);
}
