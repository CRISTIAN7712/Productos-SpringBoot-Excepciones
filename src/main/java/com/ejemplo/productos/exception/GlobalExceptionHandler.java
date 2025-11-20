package com.ejemplo.productos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * Manejador global de excepciones para la API.
 * - Captura excepciones específicas y devuelve ErrorResponse con un estado HTTP adecuado.
 * - Todas las peticiones HTTP que provoquen excepciones serán respondidas con mensajes claros.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Maneja cuando no se encuentra un recurso (404)
    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<ErrorResponse> manejarRecursoNoEncontrado(RecursoNoEncontradoException ex, WebRequest req) {
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
        // Devuelve 404 Not Found
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    // Maneja errores de validación de @Valid en los controladores (400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> manejarValidaciones(MethodArgumentNotValidException ex, WebRequest req) {
        // Extraemos el primer mensaje de error. Podrías concatenar todos si lo prefieres.
        String mensaje = "Error de validación";
        if (ex.getBindingResult().getFieldError() != null) {
            mensaje = ex.getBindingResult().getFieldError().getDefaultMessage();
        }
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), mensaje, req.getDescription(false));
        // Devuelve 400 Bad Request
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // Maneja cualquier otra excepción no controlada (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> manejarExcepcionesGenerales(Exception ex, WebRequest req) {
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), "Error interno del servidor: " + ex.getMessage(), req.getDescription(false));
        // Para seguridad, en producción normalmente no se debería devolver el mensaje de la excepción completa.
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
