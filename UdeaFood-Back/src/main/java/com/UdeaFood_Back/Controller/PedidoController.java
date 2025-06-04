package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.DTO.PedidoDTO;
import com.UdeaFood_Back.Modelo.Pedido;
import com.UdeaFood_Back.Modelo.ProductoPedido;
import com.UdeaFood_Back.Service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {


    private final PedidoService pedidoService;

    @PostMapping("/crear")
    public ResponseEntity<Pedido> crearPedido(@RequestBody PedidoDTO pedidoDTO){
        Pedido pedidoCreado = pedidoService.crearPedido(pedidoDTO);
        return ResponseEntity.ok(pedidoCreado);
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<List<ProductoPedido>> buscarPedido(@PathVariable Integer idPedido){
        return ResponseEntity.ok(pedidoService.getProductosByPedidoId(idPedido));
    }

    @GetMapping("/{idUsuario}/{idProducto}")
    public Integer getIdPedidoPorUsuarioYProducto(@PathVariable Integer idUsuario, @PathVariable Integer idProducto) {
        return pedidoService.getPedidoIdPorUsuarioYProducto(idUsuario, idProducto);
    }


}
