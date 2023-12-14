package ru.vsu.cs.buchnev.hospital.app.mapper.old;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.buchnev.hospital.api.model.request.ServiceRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.ServiceResponse;
import ru.vsu.cs.buchnev.hospital.app.service.DepartmentService;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;
import ru.vsu.cs.buchnev.hospital.item.model.ServiceItem;

import java.util.List;

@Mapper
public interface ServiceMapperOld {

    ru.vsu.cs.buchnev.hospital.app.mapper.ServiceMapper INSTANCE = Mappers.getMapper(ru.vsu.cs.buchnev.hospital.app.mapper.ServiceMapper.class);
    ServiceResponse mapToDto(ServiceItem item);
    List<ServiceResponse> mapToDto(List<ServiceItem> items);
    List<ServiceItem> mapToItem(List<ServiceResponse> items);
    ServiceItem mapToItem(ServiceResponse dto);

    default ServiceItem mapRequestToItem(ServiceRequest request, DepartmentService departmentService) {
        DepartmentItem departmentItem = departmentService.getDepartment(request.getDepartmentId());
        return ServiceItem.builder().name(request.getName()).description(request.getDescription()).price(request.getPrice()).department(departmentItem).build();
    }
}