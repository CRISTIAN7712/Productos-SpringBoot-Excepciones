package com.ejemplo.productos.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad JPA que representa la tabla "producto" en la base de datos.
 * Usamos Lombok (@Data) para generar getters/setters, equals, hashCode y toString automáticamente.
 */
@Entity                // Marca la clase como entidad gestionada por JPA
@Table(name = "producto") // Nombre de la tabla (opcional)
@Data
public class Producto {

    // PK autogenerada (IDENTITY usa la estrategia propia de la BD, en PostgreSQL es serial/sequence)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Columnas simples. Si quieres reglas adicionales (nullable, length) puedes agregarlas con @Column.
    private String nombre;

    private Double precio;

    private Integer stock;
}
