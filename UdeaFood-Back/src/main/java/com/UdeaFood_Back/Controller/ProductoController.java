package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.Modelo.Producto;
import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Producto")
public class ProductoController {

    private ProductoService productoService;

    @PostMapping("/crearProducto")

    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);

        return ResponseEntity.ok("Producto creado");
    }

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
}
