package com.example.vehiculos.application;

import com.example.vehiculos.application.dto.VehicleCreateDTO;
import com.example.vehiculos.application.dto.VehicleResponseDTO;
import com.example.vehiculos.application.dto.VehicleUpdateDTO;
import com.example.vehiculos.domain.Vehicle;
import com.example.vehiculos.domain.VehicleRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio de aplicación que contiene la lógica de casos de uso
 */
@Service
public class VehicleService {

    private final VehicleRepositoryPort repository;

    public VehicleService(VehicleRepositoryPort repository) {
        this.repository = repository;
    }

    /**
     * Crea un nuevo vehículo con status AVAILABLE
     */
    public VehicleResponseDTO create(VehicleCreateDTO dto) {
        Vehicle vehicle = Vehicle.createNew(dto.getBrand(), dto.getModel(), dto.getYear());
        Vehicle saved = repository.save(vehicle);
        return toResponseDTO(saved);
    }

    /**
     * Actualiza parcialmente un vehículo existente
     * Solo actualiza los campos no nulos del DTO
     */
    public VehicleResponseDTO update(String id, VehicleUpdateDTO dto) {
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con id: " + id));

        // Actualización parcial - solo campos no nulos
        if (dto.getBrand() != null) {
            vehicle.setBrand(dto.getBrand());
        }
        if (dto.getModel() != null) {
            vehicle.setModel(dto.getModel());
        }
        if (dto.getYear() != null) {
            vehicle.setYear(dto.getYear());
        }
        if (dto.getStatus() != null) {
            vehicle.setStatus(dto.getStatus());
        }

        Vehicle updated = repository.save(vehicle);
        return toResponseDTO(updated);
    }

    /**
     * Busca un vehículo por id
     */
    public VehicleResponseDTO findById(String id) {
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con id: " + id));
        return toResponseDTO(vehicle);
    }

    /**
     * Busca vehículos con filtros opcionales
     */
    public List<VehicleResponseDTO> find(String brand, Integer year) {
        return repository.findAll(brand, year).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    /**
     * Elimina un vehículo verificando su existencia
     */
    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Vehículo no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }

    /**
     * Mapea una entidad de dominio a DTO de respuesta
     */
    private VehicleResponseDTO toResponseDTO(Vehicle vehicle) {
        VehicleResponseDTO dto = new VehicleResponseDTO();
        dto.setId(vehicle.getId());
        dto.setBrand(vehicle.getBrand());
        dto.setModel(vehicle.getModel());
        dto.setYear(vehicle.getYear());
        dto.setStatus(vehicle.getStatus());
        dto.setCreatedAt(vehicle.getCreatedAt());
        return dto;
    }
}
