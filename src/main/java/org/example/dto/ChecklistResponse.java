package org.example.dto;

import org.example.model.VehicleType;

public record ChecklistResponse(
        Long id,
        VehicleType vehicleType,
        String checklistItem
) {
}
