package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.model.VehicleType;

public record CreateChecklistRequest(
        @NotNull(message = "Vehicle type cannot be null")
        VehicleType vehicleType,

        @NotBlank(message = "Checklist item cannot be blank")
        String checklistItem
) {
}
