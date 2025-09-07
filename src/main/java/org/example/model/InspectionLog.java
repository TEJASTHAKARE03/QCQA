package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @NotNull(message = "Inspector ID cannot be null")
    private Long inspectorId;

    @NotNull(message = "Inspector type cannot be null")
    @Enumerated(EnumType.STRING)
    private InspectorType inspectorType;

    @NotNull(message = "Inspection date cannot be null")
    private LocalDateTime inspectionDate;

    @NotNull(message = "Inspection status cannot be null")
    @Enumerated(EnumType.STRING)
    private InspectionStatus status;

    @Lob
    private String notes;
}
