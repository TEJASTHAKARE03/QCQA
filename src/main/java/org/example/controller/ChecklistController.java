package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.ChecklistResponse;
import org.example.dto.CreateChecklistRequest;
import org.example.model.VehicleType;
import org.example.service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checklists")
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @PostMapping
    public ResponseEntity<ChecklistResponse> createChecklist(@Valid @RequestBody CreateChecklistRequest request) {
        ChecklistResponse savedChecklist = checklistService.saveChecklist(request);
        return new ResponseEntity<>(savedChecklist, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ChecklistResponse> getAllChecklists() {
        return checklistService.getAllChecklists();
    }

    @GetMapping("/by-vehicle-type/{vehicleType}")
    public List<ChecklistResponse> getChecklistsByVehicleType(@PathVariable VehicleType vehicleType) {
        return checklistService.getChecklistsByVehicleType(vehicleType);
    }
}
