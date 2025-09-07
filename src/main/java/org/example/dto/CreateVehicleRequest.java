package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.example.model.VehicleType;

import java.time.LocalDate;

public record CreateVehicleRequest(
        @NotBlank(message = "Serial number cannot be blank")
        String serialNumber,

        @NotBlank(message = "Model name cannot be blank")
        String modelName,

        @NotNull(message = "Vehicle type cannot be null")
        VehicleType vehicleType,

        @NotNull(message = "Manufacturing date cannot be null")
        @PastOrPresent(message = "Manufacturing date must be in the past or present")
        LocalDate manufacturingDate
) {
}
