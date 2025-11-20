package com.ejemplo.productos.service;

import com.ejemplo.productos.dto.ProductoRequest;
import com.ejemplo.productos.entity.Producto;

import java.util.List;

/**
 * Interfaz de la capa de servicio que define las operaciones de negocio
 * relacionadas con Producto. Separar interfaz e implementación facilita
 * pruebas unitarias y mantenimiento.
 */
public interface ProductoService {
    Producto crear(ProductoRequest request);
    Producto obtenerPorId(Long id);
    List<Producto> listar();
    Producto actualizar(Long id, ProductoRequest request);
    void eliminar(Long id);
}
