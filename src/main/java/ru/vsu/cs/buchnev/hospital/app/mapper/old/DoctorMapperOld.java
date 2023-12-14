package ru.vsu.cs.buchnev.hospital.app.mapper.old;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.buchnev.hospital.api.model.request.DoctorRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.DoctorResponse;
import ru.vsu.cs.buchnev.hospital.app.service.DepartmentService;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapperOld {

    DoctorMapperOld INSTANCE = Mappers.getMapper(DoctorMapperOld.class);
    DoctorResponse mapToDto(DoctorItem item);
    List<DoctorResponse> mapToDto(List<DoctorItem> items);
    List<DoctorItem> mapToItem(List<DoctorResponse> items);
    DoctorItem mapToItem(DoctorResponse dto);

    default DoctorItem mapRequestToItem(DoctorRequest request, DepartmentService departmentService) {
        DepartmentItem departmentItem = departmentService.getDepartment(request.getDepartmentId());
        return DoctorItem.builder().fio(request.getFio()).specalization(request.getSpecalization()).department(departmentItem).build();
    }

}
