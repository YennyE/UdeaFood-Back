package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.Modelo.Producto;
import com.UdeaFood_Back.Modelo.Seccion;
import com.UdeaFood_Back.Service.ProductoService;
import com.UdeaFood_Back.Service.SeccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Seccion")
public class SeccionController {
    private SeccionService seccionService;

    @PostMapping("/crearSeccion")

    public ResponseEntity<String> crearSeccion(@RequestBody Seccion seccion) {
        seccionService.crearSeccion(seccion);

        return ResponseEntity.ok("Sección creada");
    }

    @GetMapping("/{id_tienda}")
    public ResponseEntity<List<Seccion>> getAllSeccionByIdTienda(@PathVariable Integer id_tienda){
        return ResponseEntity.ok(seccionService.getAllSeccionByIdTienda(id_tienda));
    }

    public SeccionController(SeccionService seccionService) {
        this.seccionService = seccionService;
    }
}
