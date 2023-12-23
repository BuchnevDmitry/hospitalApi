package ru.vsu.cs.buchnev.hospital.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.buchnev.hospital.api.model.request.ServiceRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.ServiceResponse;

import java.util.List;

public interface ServiceApi {
    @GetMapping("/services")
    ResponseEntity<List<ServiceResponse>> getAllServices(
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "10") int size
    );

    @GetMapping("/service/{serviceId}")
    ResponseEntity<ServiceResponse> getService(
            @PathVariable("serviceId")
            Integer serviceId
    );

    @PostMapping("/service")
    ResponseEntity<ServiceResponse> addServices(
            @RequestBody
            ServiceRequest service
    );

    @PutMapping("/service/{serviceId}")
    ResponseEntity<ServiceResponse> updateService(
            @PathVariable("serviceId")
            Integer serviceId,

            @RequestBody
            ServiceRequest service
    );

    @DeleteMapping("/service/{serviceId}")
    ResponseEntity<Void> deleteService(
            @PathVariable("serviceId")
            Integer serviceId
    );
}
