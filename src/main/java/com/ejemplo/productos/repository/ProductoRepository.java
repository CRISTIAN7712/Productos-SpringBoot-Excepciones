package com.ejemplo.productos.repository;

import com.ejemplo.productos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio Spring Data JPA.
 * Extender JpaRepository proporciona métodos CRUD listos (save, findById, findAll, deleteById, etc.).
 * No es necesario implementar nada: Spring genera la implementación en tiempo de ejecución.
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Aquí podrías agregar consultas personalizadas, por ejemplo:
    // List<Producto> findByNombreContainingIgnoreCase(String nombre);
}