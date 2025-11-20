package com.example.vehiculos.infrastructure.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositorio de Spring Data MongoDB para vehículos
 */
public interface VehicleMongoRepository extends MongoRepository<VehicleMongoDocument, String> {
}
