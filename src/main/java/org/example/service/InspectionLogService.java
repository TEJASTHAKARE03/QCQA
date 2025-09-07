package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.dto.InspectionLogResponse;
import org.example.dto.CreateInspectionLogRequest;
import org.example.dto.VehicleResponse;
import org.example.model.InspectionLog;
import org.example.model.Vehicle;
import org.example.repository.InspectionLogRepository;
import org.example.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InspectionLogService {

    @Autowired
    private InspectionLogRepository inspectionLogRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public InspectionLogResponse saveInspectionLog(CreateInspectionLogRequest request) {
        Vehicle vehicle = vehicleRepository.findById(request.vehicleId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with id: " + request.vehicleId()));

        InspectionLog inspectionLog = new InspectionLog();
        inspectionLog.setVehicle(vehicle);
        inspectionLog.setInspectorId(request.inspectorId());
        inspectionLog.setInspectorType(request.inspectorType());
        inspectionLog.setInspectionDate(request.inspectionDate());
        inspectionLog.setStatus(request.status());
        inspectionLog.setNotes(request.notes());

        InspectionLog savedLog = inspectionLogRepository.save(inspectionLog);

        return toInspectionLogResponse(savedLog);
    }

    public List<InspectionLogResponse> getAllInspectionLogs() {
        return inspectionLogRepository.findAll()
                .stream()
                .map(this::toInspectionLogResponse)
                .collect(Collectors.toList());
    }

    public Optional<InspectionLogResponse> getInspectionLogById(Long id) {
        return inspectionLogRepository.findById(id)
                .map(this::toInspectionLogResponse);
    }

    private InspectionLogResponse toInspectionLogResponse(InspectionLog log) {
        VehicleResponse vehicleResponse = new VehicleResponse(
                log.getVehicle().getId(),
                log.getVehicle().getSerialNumber(),
                log.getVehicle().getModelName(),
                log.getVehicle().getVehicleType(),
                log.getVehicle().getManufacturingDate()
        );

        return new InspectionLogResponse(
                log.getId(),
                vehicleResponse,
                log.getInspectorId(),
                log.getInspectorType(),
                log.getInspectionDate(),
                log.getStatus(),
                log.getNotes()
        );
    }
}
