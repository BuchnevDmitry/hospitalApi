package ru.vsu.cs.buchnev.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.buchnev.hospital.app.exeption.NotFoundException;
import ru.vsu.cs.buchnev.hospital.app.service.ServiceService;
import ru.vsu.cs.buchnev.hospital.item.DoctorRepository;
import ru.vsu.cs.buchnev.hospital.item.ServiceRepository;
import ru.vsu.cs.buchnev.hospital.item.model.ServiceItem;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public List<ServiceItem> getAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public ServiceItem getService(Integer serviceId) {
        return serviceRepository.findById(serviceId).orElseThrow(() -> new NotFoundException("Service with this id not found"));
    }

    @Override
    public ServiceItem createService(ServiceItem serviceItem) {
        return saveService(serviceItem);
    }

    @Override
    public ServiceItem saveService(ServiceItem currentService) {
        return serviceRepository.saveAndFlush(currentService);
    }

    @Override
    public void deleteService(Integer serviceId) {
        serviceRepository.deleteById(serviceId);
    }
}
