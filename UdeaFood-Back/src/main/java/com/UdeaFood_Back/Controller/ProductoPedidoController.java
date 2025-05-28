package com.UdeaFood_Back.Controller;


import com.UdeaFood_Back.Modelo.ProductoPedido;
import com.UdeaFood_Back.Service.ProductoPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("producto-pedido")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductoPedidoController {

    private final ProductoPedidoService productoPedidoService;

    @GetMapping("/{idUsuario}")
    public List<ProductoPedido> obtenerIdPorIdUsuario(@PathVariable Integer idUsuario) {
        return productoPedidoService.obtenerIdPorIdUsuario(idUsuario);
    }


}
