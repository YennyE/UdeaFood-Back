package com.UdeaFood_Back.Controller;


import com.UdeaFood_Back.Modelo.Seccion;
import com.UdeaFood_Back.Service.SeccionService;
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



    @PostMapping("/crearSeccion")
    public ResponseEntity<String> crearSeccion(@RequestBody Seccion seccion) {
        seccionService.crearSeccion(seccion);
        return ResponseEntity.ok("Sección creada");
    }



    @GetMapping("/{id_tienda}")
    public ResponseEntity<List<Seccion>> getAllSeccionesByIdTienda(@PathVariable Integer id_tienda){
        return ResponseEntity.ok(seccionService.getAllSeccionesByIdTienda(id_tienda));
    }


}
