package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Serial number cannot be blank")
    @Column(unique = true)
    private String serialNumber;

    @NotBlank(message = "Model name cannot be blank")
    private String modelName;

    @NotNull(message = "Vehicle type cannot be null")
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @NotNull(message = "Manufacturing date cannot be null")
    @PastOrPresent(message = "Manufacturing date must be in the past or present")
    private LocalDate manufacturingDate;
}
