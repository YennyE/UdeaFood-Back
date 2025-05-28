package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.DTO.PedidoRequest;
import com.UdeaFood_Back.Modelo.Pedido;
import com.UdeaFood_Back.Modelo.Producto;
import com.UdeaFood_Back.Modelo.ProductoPedido;
import com.UdeaFood_Back.Modelo.Usuario;
import com.UdeaFood_Back.Repository.IPedidoRepository;
import com.UdeaFood_Back.Repository.IProductoPedidoRepository;
import com.UdeaFood_Back.Repository.IProductoRepository;
import com.UdeaFood_Back.Repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class PedidoService {

    private final IUsuarioRepository usuarioRepository;
    private final IPedidoRepository pedidoRepository;
    private final IProductoRepository productoRepository;
    private final IProductoPedidoRepository productoPedidoRepository;

    public Pedido crearPedido(PedidoRequest pedidoRequest) {

        Usuario usuario = usuarioRepository.findById(pedidoRequest.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Pedido nuevoPedido = new Pedido();
        nuevoPedido.setUsuario(usuario);
        nuevoPedido.setTotal(pedidoRequest.getTotal());
        nuevoPedido.setFecha(pedidoRequest.getFecha());

        Pedido pedidoGuardado = pedidoRepository.save(nuevoPedido);

        // Crear lista de ProductoPedido
        List<ProductoPedido> productoPedidos = pedidoRequest.getProductos().stream().map(p -> {
            Producto producto = productoRepository.findById(p)
                    .orElseThrow(() -> new IllegalArgumentException("Producto con ID " + p + " no encontrado"));

            ProductoPedido productoPedido = new ProductoPedido();
            productoPedido.setCantidad(1);
            productoPedido.setPrecioUnitario(Double.valueOf(producto.getPrecio()));
            productoPedido.setProducto(producto);
            productoPedido.setPedido(pedidoGuardado); // Asociar con el pedido

            return productoPedidoRepository.save(productoPedido);
        }).toList();

        // Convertir a lista mutable
        pedidoGuardado.setProductoPedidos(new ArrayList<>(productoPedidos));

        return pedidoRepository.save(pedidoGuardado);
    }
}
