package org.example.service;

import org.example.dto.CreateVehicleRequest;
import org.example.dto.VehicleResponse;
import org.example.model.Vehicle;
import org.example.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleResponse saveVehicle(CreateVehicleRequest request) {
        // Check if a vehicle with the same serial number already exists
        Optional<Vehicle> existingVehicle = vehicleRepository.findBySerialNumber(request.serialNumber());
        if (existingVehicle.isPresent()) {
            throw new IllegalArgumentException("A vehicle with serial number '" + request.serialNumber() + "' already exists.");
        }

        // Map DTO to Entity
        Vehicle vehicle = new Vehicle();
        vehicle.setSerialNumber(request.serialNumber());
        vehicle.setModelName(request.modelName());
        vehicle.setVehicleType(request.vehicleType());
        vehicle.setManufacturingDate(request.manufacturingDate());

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        // Map Entity to Response DTO
        return toVehicleResponse(savedVehicle);
    }

    public List<VehicleResponse> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(this::toVehicleResponse)
                .collect(Collectors.toList());
    }

    public Optional<VehicleResponse> getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .map(this::toVehicleResponse);
    }

    public Optional<VehicleResponse> getVehicleBySerialNumber(String serialNumber) {
        return vehicleRepository.findBySerialNumber(serialNumber)
                .map(this::toVehicleResponse);
    }

    private VehicleResponse toVehicleResponse(Vehicle vehicle) {
        return new VehicleResponse(
                vehicle.getId(),
                vehicle.getSerialNumber(),
                vehicle.getModelName(),
                vehicle.getVehicleType(),
                vehicle.getManufacturingDate()
        );
    }
}
