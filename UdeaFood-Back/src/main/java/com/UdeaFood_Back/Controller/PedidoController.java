package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.DTO.PedidoRequest;
import com.UdeaFood_Back.Modelo.Pedido;
import com.UdeaFood_Back.Service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;


    @PostMapping("/crear-pedido")
    public ResponseEntity<Pedido> crearPedido(@RequestBody PedidoRequest pedidoRequest) {
        return ResponseEntity.ok(pedidoService.crearPedido(pedidoRequest));
    }
}
