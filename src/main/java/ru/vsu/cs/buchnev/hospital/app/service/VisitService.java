package ru.vsu.cs.buchnev.hospital.app.service;

import ru.vsu.cs.buchnev.hospital.item.model.ServiceItem;
import ru.vsu.cs.buchnev.hospital.item.model.VisitItem;

import java.util.List;

public interface VisitService {
    List<VisitItem> getAllVisit();
    VisitItem getVisit(Integer visitId);
    List<VisitItem> getVisitToPatient(Integer patientId);
    VisitItem createVisit(VisitItem visitItem);
    VisitItem saveVisit(VisitItem currentVisit);

    void deleteServiceToVisit(Integer visitId, Integer serviceId);
    void deleteVisit(Integer visitId);
}
