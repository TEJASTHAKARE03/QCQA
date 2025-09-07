package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.InspectionLog;
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
    public ResponseEntity<InspectionLog> createInspectionLog(@Valid @RequestBody InspectionLog inspectionLog) {
        InspectionLog savedLog = inspectionLogService.saveInspectionLog(inspectionLog);
        return new ResponseEntity<>(savedLog, HttpStatus.CREATED);
    }

    @GetMapping
    public List<InspectionLog> getAllInspectionLogs() {
        return inspectionLogService.getAllInspectionLogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InspectionLog> getInspectionLogById(@PathVariable Long id) {
        return inspectionLogService.getInspectionLogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
