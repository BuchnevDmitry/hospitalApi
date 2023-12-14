package ru.vsu.cs.buchnev.hospital.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.vsu.cs.buchnev.hospital.api.model.request.DoctorRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.DoctorResponse;
import ru.vsu.cs.buchnev.hospital.app.service.DepartmentService;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DoctorMapper {

    @Autowired
    protected DepartmentService departmentService;
    public abstract DoctorResponse mapToDto(DoctorItem item);
    public abstract List<DoctorResponse> mapToDto(List<DoctorItem> items);
    public abstract List<DoctorItem> mapToItem(List<DoctorResponse> items);
    public abstract DoctorItem mapToItem(DoctorResponse dto);

    @Mapping(target = "department", expression = "java(departmentService.getDepartment(request.getDepartmentId()))")
    public abstract DoctorItem mapRequestToItem(DoctorRequest request);

//    public DoctorItem mapRequestToItem(DoctorRequest request) {
//        DepartmentItem departmentItem = departmentService.getDepartment(request.getDepartmentId());
//        return DoctorItem.builder().fio(request.getFio()).specalization(request.getSpecalization()).department(departmentItem).build();
//    }
}
