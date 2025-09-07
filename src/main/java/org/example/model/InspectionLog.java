package org.example.model;

import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private Long inspectorId;

    @Enumerated(EnumType.STRING)
    private InspectorType inspectorType;

    private LocalDateTime inspectionDate;

    @Enumerated(EnumType.STRING)
    private InspectionStatus status;

    @Lob
    private String notes;
}
