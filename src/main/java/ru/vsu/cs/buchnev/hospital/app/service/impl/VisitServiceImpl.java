package ru.vsu.cs.buchnev.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.vsu.cs.buchnev.hospital.app.exeption.NotFoundException;
import ru.vsu.cs.buchnev.hospital.app.service.ServiceService;
import ru.vsu.cs.buchnev.hospital.app.service.VisitService;
import ru.vsu.cs.buchnev.hospital.item.PatientRepository;
import ru.vsu.cs.buchnev.hospital.item.VisitRepository;
import ru.vsu.cs.buchnev.hospital.item.model.PatientItem;
import ru.vsu.cs.buchnev.hospital.item.model.VisitItem;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;
    private final ServiceService serviceService;

    @Override
    public List<VisitItem> getAllVisit() {
        return visitRepository.findAll();
    }

    @Override
    public List<VisitItem> getAllVisit(PageRequest pageRequest) {
        Page<VisitItem> page = visitRepository.findAll(pageRequest);
        return page.getContent();
    }

    @Override
    public VisitItem getVisit(Integer visitId) {
        return visitRepository.findById(visitId).orElseThrow(() -> new NotFoundException("Patient with this id not found"));
    }

    @Override
    public List<VisitItem> getVisitToPatient(Integer patientId) {
        PatientItem patientItem = patientRepository.findById(patientId).orElseThrow(() -> new NotFoundException("Patient with this id not found"));;
        return visitRepository.findByPatient(patientItem);
    }

    @Override
    public VisitItem createVisit(VisitItem visitItem) {
        return saveVisit(visitItem);
    }

    @Override
    public VisitItem saveVisit(VisitItem currentVisit) {
        return visitRepository.saveAndFlush(currentVisit);
    }

    @Override
    public void deleteServiceToVisit(Integer visitId, Integer serviceId) {
        VisitItem visitItem = getVisit(visitId);
        visitItem.getServices().remove(serviceService.getService(serviceId));
        saveVisit(visitItem);
    }

    @Override
    public void deleteVisit(Integer visitId) {
        visitRepository.deleteById(visitId);
    }
}
