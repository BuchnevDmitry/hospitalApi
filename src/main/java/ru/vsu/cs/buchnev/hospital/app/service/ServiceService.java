package ru.vsu.cs.buchnev.hospital.app.service;

import org.springframework.data.domain.PageRequest;
import ru.vsu.cs.buchnev.hospital.item.model.ServiceItem;

import java.util.List;

public interface ServiceService {
    List<ServiceItem> getAllService(PageRequest pageRequest);
    ServiceItem getService(Integer serviceId);
    ServiceItem createService(ServiceItem serviceItem);
    ServiceItem saveService(ServiceItem currentService);
    void deleteService(Integer serviceId);
}
