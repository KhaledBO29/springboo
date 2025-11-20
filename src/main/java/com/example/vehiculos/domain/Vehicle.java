package com.example.vehiculos.domain;

import java.time.LocalDate;

/**
 * Entidad de dominio pura sin dependencias externas
 * Representa un vehículo en el sistema
 */
public class Vehicle {
    private String id;
    private String brand;
    private String model;
    private Integer year;
    private VehicleStatus status;
    private LocalDate createdAt;

    /**
     * Constructor público necesario para el adaptador
     */
    public Vehicle() {
    }

    /**
     * Método de fábrica para crear un nuevo vehículo
     * Asigna automáticamente status AVAILABLE y la fecha actual
     * 
     * @param brand marca del vehículo
     * @param model modelo del vehículo
     * @param year año del vehículo
     * @return nueva instancia de Vehicle
     */
    public static Vehicle createNew(String brand, String model, Integer year) {
        Vehicle vehicle = new Vehicle();
        vehicle.brand = brand;
        vehicle.model = model;
        vehicle.year = year;
        vehicle.status = VehicleStatus.AVAILABLE;
        vehicle.createdAt = LocalDate.now();
        return vehicle;
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
