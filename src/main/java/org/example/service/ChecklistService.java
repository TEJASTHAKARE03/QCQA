package org.example.service;

import org.example.dto.ChecklistResponse;
import org.example.dto.CreateChecklistRequest;
import org.example.model.Checklist;
import org.example.model.VehicleType;
import org.example.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;

    public ChecklistResponse saveChecklist(CreateChecklistRequest request) {
        Checklist checklist = new Checklist();
        checklist.setVehicleType(request.vehicleType());
        checklist.setChecklistItem(request.checklistItem());

        Checklist savedChecklist = checklistRepository.save(checklist);

        return toChecklistResponse(savedChecklist);
    }

    public List<ChecklistResponse> getAllChecklists() {
        return checklistRepository.findAll()
                .stream()
                .map(this::toChecklistResponse)
                .collect(Collectors.toList());
    }

    public List<ChecklistResponse> getChecklistsByVehicleType(VehicleType vehicleType) {
        return checklistRepository.findByVehicleType(vehicleType)
                .stream()
                .map(this::toChecklistResponse)
                .collect(Collectors.toList());
    }

    private ChecklistResponse toChecklistResponse(Checklist checklist) {
        return new ChecklistResponse(
                checklist.getId(),
                checklist.getVehicleType(),
                checklist.getChecklistItem()
        );
    }
}
