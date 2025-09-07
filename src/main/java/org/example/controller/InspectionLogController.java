package org.example.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.example.dto.InspectionLogResponse;
import org.example.dto.CreateInspectionLogRequest;
import org.example.service.InspectionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inspection-logs")
public class InspectionLogController {

    @Autowired
    private InspectionLogService inspectionLogService;

    @PostMapping
    public ResponseEntity<?> createInspectionLog(@Valid @RequestBody CreateInspectionLogRequest request) {
        try {
            InspectionLogResponse savedLog = inspectionLogService.saveInspectionLog(request);
            return new ResponseEntity<>(savedLog, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<InspectionLogResponse> getAllInspectionLogs() {
        return inspectionLogService.getAllInspectionLogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InspectionLogResponse> getInspectionLogById(@PathVariable Long id) {
        return inspectionLogService.getInspectionLogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
