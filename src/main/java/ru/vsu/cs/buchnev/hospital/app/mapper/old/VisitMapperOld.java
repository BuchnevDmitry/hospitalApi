package ru.vsu.cs.buchnev.hospital.app.mapper.old;

import org.mapstruct.Mapper;
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

@Mapper
public interface VisitMapperOld {
    ru.vsu.cs.buchnev.hospital.app.mapper.VisitMapper INSTANCE = Mappers.getMapper(ru.vsu.cs.buchnev.hospital.app.mapper.VisitMapper.class);
    VisitResponse mapToDto(VisitItem item);
    List<VisitResponse> mapToDto(List<VisitItem> items);
    List<VisitItem> mapToItem(List<VisitResponse> items);
    VisitItem mapToItem(VisitResponse dto);

    default VisitItem mapRequestToItem(VisitRequest request, PatientService patientService, DoctorService doctorService) {
        PatientItem patientItem = patientService.getPatient(request.getPatientId());
        DoctorItem doctorItem = doctorService.getDoctor(request.getDoctorId());
        return VisitItem.builder().dateVisit(request.getDateVisit()).patient(patientItem).doctor(doctorItem).build();
    }
}
