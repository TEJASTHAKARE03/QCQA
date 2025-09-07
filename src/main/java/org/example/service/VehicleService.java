package org.example.service;

import org.example.model.Vehicle;
import org.example.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(Vehicle vehicle) {
        // Check if a vehicle with the same serial number already exists
        Optional<Vehicle> existingVehicle = vehicleRepository.findBySerialNumber(vehicle.getSerialNumber());
        if (existingVehicle.isPresent()) {
            throw new IllegalArgumentException("A vehicle with serial number '" + vehicle.getSerialNumber() + "' already exists.");
        }
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Optional<Vehicle> getVehicleBySerialNumber(String serialNumber) {
        return vehicleRepository.findBySerialNumber(serialNumber);
    }
}
