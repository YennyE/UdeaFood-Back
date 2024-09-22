package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Service.TiendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Tienda")
@RequiredArgsConstructor
public class TiendaController {

    private final TiendaService tiendaService;



    @PostMapping("/crearTienda")
    public ResponseEntity<String> crearTienda(@RequestBody Tienda tienda){
        tiendaService.crear_tienda(tienda);
        return ResponseEntity.ok("Tienda creada");
    }

}
