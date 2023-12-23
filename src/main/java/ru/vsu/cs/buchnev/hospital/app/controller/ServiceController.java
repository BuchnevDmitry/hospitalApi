package ru.vsu.cs.buchnev.hospital.app.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.buchnev.hospital.api.ServiceApi;
import ru.vsu.cs.buchnev.hospital.api.model.request.ServiceRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.ServiceResponse;
import ru.vsu.cs.buchnev.hospital.app.mapper.ServiceMapper;
import ru.vsu.cs.buchnev.hospital.app.service.ServiceService;
import ru.vsu.cs.buchnev.hospital.app.service.VisitService;
import ru.vsu.cs.buchnev.hospital.item.model.ServiceItem;
import ru.vsu.cs.buchnev.hospital.item.model.VisitItem;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServiceController implements ServiceApi {

    private final ServiceService serviceService;
    private final VisitService visitService;
    private final ServiceMapper serviceMapper;

    @Override
    public ResponseEntity<List<ServiceResponse>> getAllServices(int page, int size) {
        List<ServiceItem> allServices = serviceService.getAllService(PageRequest.of(page, size));
        return ResponseEntity.ok(serviceMapper.mapToDto(allServices));
    }

    @Override
    public ResponseEntity<ServiceResponse> getService(Integer serviceId) {
        ServiceItem serviceItem = serviceService.getService(serviceId);
        return ResponseEntity.ok(serviceMapper.mapToDto(serviceItem));
    }

    @Override
    public ResponseEntity<ServiceResponse> addServices(ServiceRequest service) {
        ServiceItem serviceItem = serviceMapper.mapRequestToItem(service);
        ServiceItem createdService = serviceService.createService(serviceItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceMapper.mapToDto(createdService));
    }

    @Override
    public ResponseEntity<ServiceResponse> updateService(Integer serviceId, ServiceRequest service) {
        ServiceItem serviceItem = serviceMapper.mapRequestToItem(service);
        ServiceItem currentItem = serviceService.getService(serviceId);
        currentItem.setName(serviceItem.getName());
        currentItem.setDescription(serviceItem.getDescription());
        currentItem.setPrice(serviceItem.getPrice());
        currentItem.setDepartment(serviceItem.getDepartment());
        ServiceItem updatedService = serviceService.saveService(currentItem);
        return ResponseEntity.ok(serviceMapper.mapToDto(updatedService));
    }

    @Override
    public ResponseEntity<Void> deleteService(Integer serviceId) {
        for (VisitItem item: visitService.getAllVisit(PageRequest.of(page, size))) {
            visitService.deleteServiceToVisit(item.getId(), serviceId);
        }
        serviceService.deleteService(serviceId);
        return ResponseEntity.ok().build();
    }
}
