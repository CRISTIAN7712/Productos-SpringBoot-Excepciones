package com.ejemplo.productos.service.impl;

import com.ejemplo.productos.dto.ProductoRequest;
import com.ejemplo.productos.entity.Producto;
import com.ejemplo.productos.exception.RecursoNoEncontradoException;
import com.ejemplo.productos.repository.ProductoRepository;
import com.ejemplo.productos.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de la lógica de negocio para productos.
 * Se inyecta ProductoRepository para interactuar con la base de datos.
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repo;

    // Constructor para inyección de dependencias (Spring lo inyecta automáticamente)
    public ProductoServiceImpl(ProductoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Producto crear(ProductoRequest request) {
        // Creamos una entidad Producto y llenamos sus campos desde el DTO
        Producto p = new Producto();
        p.setNombre(request.nombre());
        p.setPrecio(request.precio());
        p.setStock(request.stock());
        // Guardamos en BD y devolvemos la entidad persistida (con id generado)
        return repo.save(p);
    }

    @Override
    public Producto obtenerPorId(Long id) {
        // findById devuelve Optional: si no existe, lanzamos nuestra excepción personalizada
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con id " + id));
    }

    @Override
    public List<Producto> listar() {
        // Devolvemos todos los productos
        return repo.findAll();
    }

    @Override
    public Producto actualizar(Long id, ProductoRequest request) {
        // Obtenemos el producto (o lanzamos 404). Luego actualizamos campos y guardamos.
        Producto p = obtenerPorId(id);
        p.setNombre(request.nombre());
        p.setPrecio(request.precio());
        p.setStock(request.stock());
        return repo.save(p);
    }

    @Override
    public void eliminar(Long id) {
        // Comprobamos existencia y eliminamos; si no existe, lanzamos 404.
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("No existe producto con id " + id);
        }
        repo.deleteById(id);
    }
}
