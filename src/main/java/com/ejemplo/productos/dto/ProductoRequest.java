package com.ejemplo.productos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO inmutable (Java record) para recibir datos de entrada en peticiones HTTP.
 * Se usa validación con anotaciones de Jakarta Validation para garantizar datos válidos.
 */
public record ProductoRequest(
        @NotBlank(message = "El nombre no puede estar vacío") String nombre,
        @NotNull(message = "El precio es requerido") @Min(value = 1, message = "El precio debe ser mayor a 0") Double precio,
        @NotNull(message = "El stock es requerido") @Min(value = 0, message = "El stock debe ser 0 o mayor") Integer stock
) {}
