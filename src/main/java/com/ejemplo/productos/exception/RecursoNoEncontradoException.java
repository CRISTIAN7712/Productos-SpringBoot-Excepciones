package com.ejemplo.productos.exception;

/**
 * Excepción personalizada para representar el caso "recurso no encontrado".
 * Es RuntimeException para que pueda propagarse y ser manejada por un @ControllerAdvice global.
 */
public class RecursoNoEncontradoException extends RuntimeException {
    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
