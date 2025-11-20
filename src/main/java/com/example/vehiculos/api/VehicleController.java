package com.example.vehiculos.api;

import com.example.vehiculos.application.VehicleService;
import com.example.vehiculos.application.dto.VehicleCreateDTO;
import com.example.vehiculos.application.dto.VehicleResponseDTO;
import com.example.vehiculos.application.dto.VehicleUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que expone los endpoints de la API
 */
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    /**
     * Crea un nuevo vehículo
     */
    @PostMapping
    public ResponseEntity<VehicleResponseDTO> create(@Valid @RequestBody VehicleCreateDTO dto) {
        VehicleResponseDTO created = vehicleService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Lista vehículos con filtros opcionales
     */
    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> findAll(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Integer year) {
        List<VehicleResponseDTO> vehicles = vehicleService.find(brand, year);
        return ResponseEntity.ok(vehicles);
    }

    /**
     * Obtiene un vehículo por id
     */
    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> findById(@PathVariable String id) {
        VehicleResponseDTO vehicle = vehicleService.findById(id);
        return ResponseEntity.ok(vehicle);
    }

    /**
     * Actualiza parcialmente un vehículo
     */
    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> update(
            @PathVariable String id,
            @Valid @RequestBody VehicleUpdateDTO dto) {
        VehicleResponseDTO updated = vehicleService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    /**
     * Elimina un vehículo
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Maneja excepciones y devuelve respuesta 404
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /**
     * Clase interna para respuestas de error
     */
    public static class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
