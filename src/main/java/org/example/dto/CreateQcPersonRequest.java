package org.example.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateQcPersonRequest(
        @NotBlank(message = "Name cannot be blank")
        String name,

        int qcScore,

        @NotBlank(message = "Vehicle type is mandatory")
        String vehicleType
) {
}
