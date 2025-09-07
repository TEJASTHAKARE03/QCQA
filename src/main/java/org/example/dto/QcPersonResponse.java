package org.example.dto;

public record QcPersonResponse(
        Integer id,
        String name,
        int qcScore,
        String vehicleType
) {
}
