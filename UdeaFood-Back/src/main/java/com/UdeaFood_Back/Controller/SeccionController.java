package com.UdeaFood_Back.Controller;


import com.UdeaFood_Back.Modelo.Seccion;
import com.UdeaFood_Back.Service.SeccionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Seccion")
@RequiredArgsConstructor
public class SeccionController {

    private final SeccionService seccionService;


    @Operation(summary = "Crear una nueva sección", description = "Permite crear una nueva sección en de una tienda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sección creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("/crearSeccion")
    public ResponseEntity<String> crearSeccion(@RequestBody Seccion seccion) {
        seccionService.crearSeccion(seccion);
        return ResponseEntity.ok("Sección creada");
    }


    @Operation(summary = "Obtener secciones por tienda", description = "Retorna una lista de todas las secciones de una tienda específica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de secciones obtenida exitosamente"),
            @ApiResponse(responseCode = "404", description = "Tienda no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id_tienda}")
    public ResponseEntity<List<Seccion>> getAllSeccionesByIdTienda(@PathVariable Integer id_tienda){
        return ResponseEntity.ok(seccionService.getAllSeccionesByIdTienda(id_tienda));
    }





    @GetMapping("/tipo/{tipo_tienda}/{palabra}")
    public ResponseEntity<List<Seccion>> getAllSeccionesByTipoTienda(@PathVariable String tipo_tienda, @PathVariable String palabra){
        return ResponseEntity.ok(seccionService.getAllSeccionesByTipoTienda(tipo_tienda, palabra));
    }


}
