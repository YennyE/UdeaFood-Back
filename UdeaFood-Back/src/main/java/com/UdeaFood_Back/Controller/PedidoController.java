package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.DTO.PedidoDTO;
import com.UdeaFood_Back.Modelo.Pedido;
import com.UdeaFood_Back.Service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping("/crear")
    public ResponseEntity<Pedido> crearPedido(@RequestBody PedidoDTO pedidoDTO){
        Pedido pedidoCreado = pedidoService.crearPedido(pedidoDTO);
        return ResponseEntity.ok(pedidoCreado);
    }




}
