package com.example.vehiculos.infrastructure.mongo;

import com.example.vehiculos.domain.VehicleStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * Documento MongoDB que representa un vehículo
 */
@Document(collection = "vehicles")
public class VehicleMongoDocument {
    
    @Id
    private String id;
    private String brand;
    private String model;
    private Integer year;
    private VehicleStatus status;
    private LocalDate createdAt;

    // Constructor vacío requerido por Spring Data
    public VehicleMongoDocument() {
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
