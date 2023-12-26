package ru.vsu.cs.buchnev.hospital.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import ru.vsu.cs.buchnev.hospital.api.model.request.DoctorRequest;
import ru.vsu.cs.buchnev.hospital.api.model.request.ServiceRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.DepartmentResponse;
import ru.vsu.cs.buchnev.hospital.api.model.response.ServiceResponse;
import ru.vsu.cs.buchnev.hospital.app.service.DepartmentService;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;
import ru.vsu.cs.buchnev.hospital.item.model.ServiceItem;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ServiceMapper {
    @Autowired
    protected DepartmentService departmentService;
    public ServiceResponse mapToDto(ServiceItem item) {
        return ServiceResponse.builder().id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .price(item.getPrice())
                .department(DepartmentResponse.builder()
                        .id(item.getDepartment().getId())
                        .name(item.getDepartment().getName())
                        .address(item.getDepartment().getAddress()).build()).build();
    };
    public abstract List<ServiceResponse> mapToDto(List<ServiceItem> items);
    public abstract List<ServiceItem> mapToItem(List<ServiceResponse> items);
    public abstract ServiceItem mapToItem(ServiceResponse dto);
    @Mapping(target = "department", expression = "java(departmentService.getDepartment(request.getDepartmentId()))")
    public abstract ServiceItem mapRequestToItem(ServiceRequest request);

//    default ServiceItem mapRequestToItem(ServiceRequest request, DepartmentService departmentService) {
//        DepartmentItem departmentItem = departmentService.getDepartment(request.getDepartmentId());
//        return ServiceItem.builder().name(request.getName()).description(request.getDescription()).price(request.getPrice()).department(departmentItem).build();
//    }
}
