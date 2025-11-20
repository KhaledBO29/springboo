package com.example.vehiculos.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO para crear un nuevo vehículo
 */
public class VehicleCreateDTO {
    
    @NotBlank(message = "La marca no puede estar vacía")
    private String brand;
    
    @NotBlank(message = "El modelo no puede estar vacío")
    private String model;
    
    @NotNull(message = "El año no puede ser nulo")
    @Min(value = 1900, message = "El año debe ser mayor o igual a 1900")
    @Max(value = 2100, message = "El año debe ser menor o igual a 2100")
    private Integer year;

    // Constructor vacío
    public VehicleCreateDTO() {
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
}
