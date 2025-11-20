package com.example.vehiculos.application.dto;

import com.example.vehiculos.domain.VehicleStatus;

import java.time.LocalDate;

/**
 * DTO para respuesta de vehículo
 */
public class VehicleResponseDTO {
    
    private String id;
    private String brand;
    private String model;
    private Integer year;
    private VehicleStatus status;
    private LocalDate createdAt;

    // Constructor vacío
    public VehicleResponseDTO() {
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
