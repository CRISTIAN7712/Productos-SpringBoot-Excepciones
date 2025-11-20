package com.ejemplo.productos.exception;

import java.time.LocalDateTime;

/**
 * DTO para estandarizar las respuestas de error que se devuelven por la API.
 * Incluye timestamp, mensaje y la ruta (o descripción) de la petición.
 */
public record ErrorResponse(
        LocalDateTime timestamp,
        String mensaje,
        String ruta
) {}
