package com.example.vehiculos.application.dto;

import com.example.vehiculos.domain.VehicleStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

/**
 * DTO para actualizar un vehículo (actualización parcial)
 * Todos los campos son opcionales
 */
public class VehicleUpdateDTO {
    
    private String brand;
    private String model;
    
    @Min(value = 1900, message = "El año debe ser mayor o igual a 1900")
    @Max(value = 2100, message = "El año debe ser menor o igual a 2100")
    private Integer year;
    
    private VehicleStatus status;

    // Constructor vacío
    public VehicleUpdateDTO() {
    }

    // Getters y Setters
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
}
