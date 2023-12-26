package ru.vsu.cs.buchnev.hospital.app.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.buchnev.hospital.api.model.request.DepartmentRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.DepartmentResponse;
import ru.vsu.cs.buchnev.hospital.api.model.response.DoctorResponse;
import ru.vsu.cs.buchnev.hospital.api.model.response.ServiceResponse;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;
import ru.vsu.cs.buchnev.hospital.item.model.ServiceItem;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DepartmentMapper {
    public abstract DepartmentItem mapRequestToItem(DepartmentRequest departmentRequest);
    public abstract DepartmentResponse mapToDto(DepartmentItem item);

    public abstract List<DepartmentResponse> mapToDto(List<DepartmentItem> items);

//    public DepartmentResponse mapCustomItemResponse(DepartmentItem departmentItem) {
//        return DepartmentResponse.builder().id(departmentItem.getId())
//                .name(departmentItem.getName()).address(departmentItem.getAddress()).build();
//    }

    protected DoctorResponse doctorItemToDoctorResponse(DoctorItem doctorItem) {
        if ( doctorItem == null ) {
            return null;
        }

        DoctorResponse.DoctorResponseBuilder doctorResponse = DoctorResponse.builder();

        doctorResponse.id( doctorItem.getId() );
        doctorResponse.fio( doctorItem.getFio() );
        doctorResponse.specalization( doctorItem.getSpecalization() );
        return doctorResponse.build();
    }
    protected ServiceResponse serviceItemToServiceResponse(ServiceItem serviceItem) {
        if ( serviceItem == null ) {
            return null;
        }

        ServiceResponse.ServiceResponseBuilder serviceResponse = ServiceResponse.builder();
        serviceResponse.id( serviceItem.getId() );
        serviceResponse.name( serviceItem.getName() );
        serviceResponse.description( serviceItem.getDescription() );
        serviceResponse.price( serviceItem.getPrice() );
        return serviceResponse.build();
    }
    public abstract List<DepartmentItem> mapToItem(List<DepartmentResponse> items);
    public abstract DepartmentItem mapToItem(DepartmentResponse dto);
}
