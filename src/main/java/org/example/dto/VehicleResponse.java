package org.example.dto;

import org.example.model.VehicleType;

import java.time.LocalDate;

public record VehicleResponse(
        Long id,
        String serialNumber,
        String modelName,
        VehicleType vehicleType,
        LocalDate manufacturingDate
) {
}
