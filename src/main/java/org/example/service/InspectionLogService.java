package org.example.service;

import org.example.model.InspectionLog;
import org.example.repository.InspectionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InspectionLogService {

    @Autowired
    private InspectionLogRepository inspectionLogRepository;

    public InspectionLog saveInspectionLog(InspectionLog inspectionLog) {
        // In a real application, you might add more complex business logic here,
        // such as validating that the inspectorId and vehicleId are valid.
        return inspectionLogRepository.save(inspectionLog);
    }

    public List<InspectionLog> getAllInspectionLogs() {
        return inspectionLogRepository.findAll();
    }

    public Optional<InspectionLog> getInspectionLogById(Long id) {
        return inspectionLogRepository.findById(id);
    }
}
