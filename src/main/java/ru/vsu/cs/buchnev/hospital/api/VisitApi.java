package ru.vsu.cs.buchnev.hospital.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.buchnev.hospital.api.model.request.VisitRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.VisitResponse;

import java.util.List;

public interface VisitApi {
    @GetMapping("/visits")
    ResponseEntity<List<VisitResponse>> getAllVisits();

    @GetMapping("/visit/{visitId}")
    ResponseEntity<VisitResponse> getVisit(
            @PathVariable("visitId")
            Integer visitId
    );

    @GetMapping("/visit/patient/{patientId}")
    ResponseEntity<List<VisitResponse>> getVisitToDepartment(
            @PathVariable("patientId")
            Integer patientId
    );

    @PostMapping("/visit")
    ResponseEntity<VisitResponse> addServiceToVisit(
            @RequestBody
            VisitRequest visit
    );

    @PutMapping("/visit/{visitId}")
    ResponseEntity<VisitResponse> updateVisit(
            @PathVariable("visitId")
            Integer visitId,

            @RequestBody
            VisitRequest visit
    );

    @DeleteMapping("/visit/{visitId}")
    ResponseEntity<Void> deleteVisit(
            @PathVariable("visitId")
            Integer visitId
    );

    @PostMapping("/visit/{visitId}/add/service/{serviceId}")
    ResponseEntity<VisitResponse> addServiceToVisit(
            @PathVariable("visitId")
            Integer visitId,

            @PathVariable("serviceId")
            Integer serviceId
    );

    @DeleteMapping("/visit/{visitId}/delete/service/{serviceId}")
    ResponseEntity<Void> deleteServiceToVisit(
            @PathVariable("visitId")
            Integer visitId,

            @PathVariable("serviceId")
            Integer serviceId
    );
}
