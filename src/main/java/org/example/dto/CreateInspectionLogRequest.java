package org.example.dto;

import jakarta.validation.constraints.NotNull;
import org.example.model.InspectionStatus;
import org.example.model.InspectorType;

import java.time.LocalDateTime;

public record CreateInspectionLogRequest(
        @NotNull(message = "Vehicle ID cannot be null")
        Long vehicleId,

        @NotNull(message = "Inspector ID cannot be null")
        Long inspectorId,

        @NotNull(message = "Inspector type cannot be null")
        InspectorType inspectorType,

        @NotNull(message = "Inspection date cannot be null")
        LocalDateTime inspectionDate,

        @NotNull(message = "Inspection status cannot be null")
        InspectionStatus status,

        String notes
) {
}
