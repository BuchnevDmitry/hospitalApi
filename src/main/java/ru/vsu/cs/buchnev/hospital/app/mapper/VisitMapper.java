package ru.vsu.cs.buchnev.hospital.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import ru.vsu.cs.buchnev.hospital.api.model.request.ServiceRequest;
import ru.vsu.cs.buchnev.hospital.api.model.request.VisitRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.VisitResponse;
import ru.vsu.cs.buchnev.hospital.app.service.DepartmentService;
import ru.vsu.cs.buchnev.hospital.app.service.DoctorService;
import ru.vsu.cs.buchnev.hospital.app.service.PatientService;
import ru.vsu.cs.buchnev.hospital.item.model.*;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class VisitMapper {
    @Autowired
    protected DoctorService doctorService;
    @Autowired
    protected PatientService patientService;
    public abstract VisitResponse mapToDto(VisitItem item);
    public abstract List<VisitResponse> mapToDto(List<VisitItem> items);
    public abstract List<VisitItem> mapToItem(List<VisitResponse> items);
    public abstract VisitItem mapToItem(VisitResponse dto);
    @Mappings({
            @Mapping(target = "doctor", expression = "java(doctorService.getDoctor(request.getDoctorId()))"),
            @Mapping(target = "patient", expression = "java(patientService.getPatient(request.getPatientId()))")
    })
    public abstract VisitItem mapRequestToItem(VisitRequest request);

//    default VisitItem mapRequestToItem(VisitRequest request, PatientService patientService, DoctorService doctorService) {
//        PatientItem patientItem = patientService.getPatient(request.getPatientId());
//        DoctorItem doctorItem = doctorService.getDoctor(request.getDoctorId());
//        return VisitItem.builder().dateVisit(request.getDateVisit()).patient(patientItem).doctor(doctorItem).build();
//    }
}
