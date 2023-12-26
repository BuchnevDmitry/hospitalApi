package ru.vsu.cs.buchnev.hospital.app.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.buchnev.hospital.api.VisitApi;
import ru.vsu.cs.buchnev.hospital.api.model.request.VisitRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.VisitResponse;
import ru.vsu.cs.buchnev.hospital.app.mapper.VisitMapper;
import ru.vsu.cs.buchnev.hospital.app.service.DoctorService;
import ru.vsu.cs.buchnev.hospital.app.service.PatientService;
import ru.vsu.cs.buchnev.hospital.app.service.ServiceService;
import ru.vsu.cs.buchnev.hospital.app.service.VisitService;
import ru.vsu.cs.buchnev.hospital.item.model.VisitItem;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VisitController implements VisitApi {
    private final VisitService visitService;
    private final ServiceService serviceService;
    private final VisitMapper visitMapper;

    @Override
    public ResponseEntity<List<VisitResponse>> getAllVisits(int page, int size) {
        List<VisitItem> allVisits = visitService.getAllVisit(PageRequest.of(page, size));
        return ResponseEntity.ok(visitMapper.mapToDto(allVisits));
    }

    @Override
    public ResponseEntity<List<VisitResponse>> getVisitsWithFilter(String date, int page, int size) {
        List<VisitItem> allVisits = visitService.getAllVisit(date, PageRequest.of(page, size));
        return ResponseEntity.ok(visitMapper.mapToDto(allVisits));
    }

    @Override
    public ResponseEntity<VisitResponse> getVisit(Integer visitId) {
        VisitItem visitItem = visitService.getVisit(visitId);
        return ResponseEntity.ok(visitMapper.mapToDto(visitItem));
    }

    @Override
    public ResponseEntity<List<VisitResponse>> getVisitToDepartment(Integer patientId) {
        List<VisitResponse> visitResponses = visitMapper.mapToDto(visitService.getVisitToPatient(patientId));
        return ResponseEntity.ok(visitResponses);

    }

    @Override
    public ResponseEntity<VisitResponse> addServiceToVisit(VisitRequest visit) {
        VisitItem visitItem = visitMapper.mapRequestToItem(visit);
        VisitItem createdVisit = visitService.createVisit(visitItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(visitMapper.mapToDto(createdVisit));
    }

    @Override
    public ResponseEntity<VisitResponse> updateVisit(Integer visitId, VisitRequest visit) {
        VisitItem visitItem = visitMapper.mapRequestToItem(visit);
        VisitItem currentItem = visitService.getVisit(visitId);
        currentItem.setDateVisit(visitItem.getDateVisit());
        currentItem.setDoctor(visitItem.getDoctor());
        currentItem.setPatient(visitItem.getPatient());
        VisitItem updatedVisit = visitService.saveVisit(currentItem);
        return ResponseEntity.ok(visitMapper.mapToDto(updatedVisit));
    }

    @Override
    public ResponseEntity<Void> deleteVisit(Integer visitId) {
        visitService.deleteVisit(visitId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<VisitResponse> addServiceToVisit(Integer visitId, Integer serviceId) {
        VisitItem visitItem = visitService.getVisit(visitId);
        visitItem.getServices().add(serviceService.getService(serviceId));
        visitService.saveVisit(visitItem);
        return ResponseEntity.ok(visitMapper.mapToDto(visitItem));
    }

    @Override
    public ResponseEntity<Void> deleteServiceToVisit(Integer visitId, Integer serviceId) {
        visitService.deleteServiceToVisit(visitId, serviceId);
        return ResponseEntity.ok().build();
    }
}
