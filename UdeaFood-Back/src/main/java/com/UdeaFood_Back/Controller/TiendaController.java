package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Modelo.TipoTienda;
import com.UdeaFood_Back.Service.TiendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;


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
    public ResponseEntity<String> crearTienda(@RequestBody Tienda tienda) {
        try {
            tiendaService.crear_tienda(tienda);
            return ResponseEntity.ok("Tienda creada exitosamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Solicitud incorrecta: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno: " + e.getMessage());
        }
    }


    //Endpoint para obtener tiendas por tipo de tienda
    @GetMapping("/tipoTienda/{tipoTienda}")
    public ResponseEntity<List<Tienda>> getTiendasByTipotienda(@PathVariable TipoTienda tipoTienda){
        List<Tienda> tiendas = tiendaService.getTiendasByTipoTienda(tipoTienda);
        return ResponseEntity.ok(tiendas);
    }
  
  
    //Endpoint para obtener todas las tiendas
   @GetMapping("/todas")
    public ResponseEntity<List<Tienda>> getAllTiendas(){
        List<Tienda> tiendas = tiendaService.getAllTiendas();
        return ResponseEntity.ok(tiendas);
    }


}
