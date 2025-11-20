package com.example.vehiculos.domain;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de dominio para acceso a vehículos (arquitectura hexagonal)
 * Define las operaciones de persistencia necesarias sin acoplarse a la tecnología
 */
public interface VehicleRepositoryPort {
    
    /**
     * Guarda un vehículo
     * 
     * @param vehicle vehículo a guardar
     * @return vehículo guardado con id asignado
     */
    Vehicle save(Vehicle vehicle);
    
    /**
     * Busca un vehículo por su id
     * 
     * @param id identificador del vehículo
     * @return Optional con el vehículo si existe
     */
    Optional<Vehicle> findById(String id);
    
    /**
     * Busca vehículos con filtros opcionales
     * 
     * @param brand marca del vehículo (opcional)
     * @param year año del vehículo (opcional)
     * @return lista de vehículos que cumplen los criterios
     */
    List<Vehicle> findAll(String brand, Integer year);
    
    /**
     * Elimina un vehículo por su id
     * 
     * @param id identificador del vehículo
     */
    void deleteById(String id);
    
    /**
     * Verifica si existe un vehículo con el id dado
     * 
     * @param id identificador del vehículo
     * @return true si existe, false en caso contrario
     */
    boolean existsById(String id);
}
