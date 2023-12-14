package ru.vsu.cs.buchnev.hospital.app.service;

import ru.vsu.cs.buchnev.hospital.item.model.PatientItem;
import ru.vsu.cs.buchnev.hospital.item.model.ServiceItem;

import java.util.List;

public interface ServiceService {
    List<ServiceItem> getAllService();
    ServiceItem getService(Integer serviceId);
    ServiceItem createService(ServiceItem serviceItem);
    ServiceItem saveService(ServiceItem currentService);
    void deleteService(Integer serviceId);
}
