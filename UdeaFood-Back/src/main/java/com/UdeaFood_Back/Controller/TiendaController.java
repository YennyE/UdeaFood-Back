package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Service.TiendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Tienda")
@RequiredArgsConstructor
public class TiendaController {

    private final TiendaService tiendaService;


    @Operation(summary = "Crear una nueva tienda", description = "Permite crear una nueva tienda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tienda creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("/crearTienda")
    public ResponseEntity<String> crearTienda(@RequestBody Tienda tienda){
        tiendaService.crear_tienda(tienda);
        return ResponseEntity.ok("Tienda creada");
    }

}
