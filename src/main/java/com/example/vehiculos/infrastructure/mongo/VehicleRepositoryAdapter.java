package com.example.vehiculos.infrastructure.mongo;

import com.example.vehiculos.domain.Vehicle;
import com.example.vehiculos.domain.VehicleRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Adaptador que implementa el puerto usando MongoDB
 * Realiza el filtrado en memoria usando streams de Java
 */
@Component
public class VehicleRepositoryAdapter implements VehicleRepositoryPort {

    private final VehicleMongoRepository mongoRepository;

    public VehicleRepositoryAdapter(VehicleMongoRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        VehicleMongoDocument document = toDocument(vehicle);
        VehicleMongoDocument saved = mongoRepository.save(document);
        return toDomain(saved);
    }

    @Override
    public Optional<Vehicle> findById(String id) {
        return mongoRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Vehicle> findAll(String brand, Integer year) {
        // Obtener todos los documentos de MongoDB
        List<VehicleMongoDocument> allDocuments = mongoRepository.findAll();
        
        // Aplicar filtros en memoria usando streams
        return allDocuments.stream()
                .filter(doc -> brand == null || doc.getBrand().equalsIgnoreCase(brand))
                .filter(doc -> year == null || doc.getYear().equals(year))
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        mongoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return mongoRepository.existsById(id);
    }

    /**
     * Convierte una entidad de dominio a documento MongoDB
     */
    private VehicleMongoDocument toDocument(Vehicle vehicle) {
        VehicleMongoDocument document = new VehicleMongoDocument();
        document.setId(vehicle.getId());
        document.setBrand(vehicle.getBrand());
        document.setModel(vehicle.getModel());
        document.setYear(vehicle.getYear());
        document.setStatus(vehicle.getStatus());
        document.setCreatedAt(vehicle.getCreatedAt());
        return document;
    }

    /**
     * Convierte un documento MongoDB a entidad de dominio
     */
    private Vehicle toDomain(VehicleMongoDocument document) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(document.getId());
        vehicle.setBrand(document.getBrand());
        vehicle.setModel(document.getModel());
        vehicle.setYear(document.getYear());
        vehicle.setStatus(document.getStatus());
        vehicle.setCreatedAt(document.getCreatedAt());
        return vehicle;
    }
}
