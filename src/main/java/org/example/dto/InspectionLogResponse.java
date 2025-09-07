package org.example.dto;

import org.example.model.InspectionStatus;
import org.example.model.InspectorType;

import java.time.LocalDateTime;

public record InspectionLogResponse(
        Long id,
        VehicleResponse vehicle,
        Long inspectorId,
        InspectorType inspectorType,
        LocalDateTime inspectionDate,
        InspectionStatus status,
        String notes
) {
}
