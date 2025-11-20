package com.ejemplo.productos.controller;

import com.ejemplo.productos.dto.ProductoRequest;
import com.ejemplo.productos.entity.Producto;
import com.ejemplo.productos.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Controlador REST que expone los endpoints para gestionar productos.
 * Cada endpoint devuelve tipos HTTP apropiados y usa validación con @Valid.
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    // Inyección por constructor del servicio
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    /**
     * Crea un nuevo producto.
     * - @Valid valida el DTO antes de entrar al método.
     * - Devuelve 201 Created con la entidad creada (y header Location opcional).
     */
    @PostMapping
    public ResponseEntity<Producto> crear(@Valid @RequestBody ProductoRequest request) {
        Producto creado = service.crear(request);
        // Construimos la URI del recurso creado: /api/productos/{id}
        URI location = URI.create(String.format("/api/productos/%d", creado.getId()));
        return ResponseEntity.created(location).body(creado); // 201 Created
    }

    /**
     * Obtiene un producto por id.
     * - Si no existe, el servicio lanza RecursoNoEncontradoException → manejado por GlobalExceptionHandler.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtener(@PathVariable Long id) {
        Producto p = service.obtenerPorId(id);
        return ResponseEntity.ok(p); // 200 OK
    }

    /**
     * Lista todos los productos.
     */
    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(service.listar()); // 200 OK
    }

    /**
     * Actualiza un producto completamente.
     * - Usa @Valid para validar el body.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @Valid @RequestBody ProductoRequest request) {
        Producto actualizado = service.actualizar(id, request);
        return ResponseEntity.ok(actualizado); // 200 OK
    }

    /**
     * Elimina un producto.
     * - Si no existe, el servicio lanza RecursoNoEncontradoException → 404.
     * - Si se elimina con éxito, devolvemos 204 No Content (sin body).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
