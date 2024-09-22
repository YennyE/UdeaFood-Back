package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.Modelo.Producto;
import com.UdeaFood_Back.Service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;


    @Operation(summary = "Crear un nuevo producto", description = "Permite crear un nuevo producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El producto se creó exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("/crearProducto")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);

        return ResponseEntity.ok("Producto creado");
    }

}
