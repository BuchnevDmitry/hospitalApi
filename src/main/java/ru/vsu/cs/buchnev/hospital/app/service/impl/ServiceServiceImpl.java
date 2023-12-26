package ru.vsu.cs.buchnev.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.vsu.cs.buchnev.hospital.app.exeption.NotFoundException;
import ru.vsu.cs.buchnev.hospital.app.service.ServiceService;
import ru.vsu.cs.buchnev.hospital.helper.Result;
import ru.vsu.cs.buchnev.hospital.specification.ServiceSpecifications;
import ru.vsu.cs.buchnev.hospital.item.ServiceRepository;
import ru.vsu.cs.buchnev.hospital.item.model.ServiceItem;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public List<ServiceItem> getAllService(PageRequest pageRequest) {
        Page<ServiceItem> page = serviceRepository.findAll(pageRequest);
        return page.getContent();
    }

    @Override
    public List<ServiceItem> getAllService(String name, PageRequest pageRequest) {
        Page<ServiceItem> page = serviceRepository.findAll(Specification.where(ServiceSpecifications.hasName(name)), pageRequest);
        return page.getContent();
    }

    @Override
    public Result getServiceResult() {
        return serviceRepository.findServicesAndStatsByAllAndDateRange();
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
