package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.DTO.MetodoPagoDTO;
import com.UdeaFood_Back.Modelo.MetodoPago;
import com.UdeaFood_Back.Service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiendas/{idTienda}/metodos-pago")
@CrossOrigin(origins = "http://localhost:3000")
public class MetodoPagoController {

    private final MetodoPagoService metodoPagoService;

    @Autowired
    public MetodoPagoController(MetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    @GetMapping
    public ResponseEntity<List<MetodoPago>> obtenerMetodosPago(@PathVariable Integer idTienda) {
        return ResponseEntity.ok(metodoPagoService.obtenerMetodosPorTienda(idTienda));
    }

    @PostMapping
    public ResponseEntity<MetodoPago> agregarMetodoPago(
            @PathVariable Integer idTienda,
            @RequestBody MetodoPagoDTO metodoPagoDTO) {
        metodoPagoDTO.setIdTienda(idTienda);
        return ResponseEntity.ok(metodoPagoService.agregarMetodoPago(metodoPagoDTO));
    }

    @DeleteMapping("/{idMetodo}")
    public ResponseEntity<Void> eliminarMetodoPago(
            @PathVariable Integer idTienda,
            @PathVariable Integer idMetodo) {
        metodoPagoService.eliminarMetodoPago(idMetodo, idTienda);
        return ResponseEntity.noContent().build();
    }
}
