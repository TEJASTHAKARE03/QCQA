package org.example.service;

import org.example.model.Checklist;
import org.example.model.VehicleType;
import org.example.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;

    public Checklist saveChecklist(Checklist checklist) {
        return checklistRepository.save(checklist);
    }

    public List<Checklist> getAllChecklists() {
        return checklistRepository.findAll();
    }

    public List<Checklist> getChecklistsByVehicleType(VehicleType vehicleType) {
        return checklistRepository.findByVehicleType(vehicleType);
    }
}
