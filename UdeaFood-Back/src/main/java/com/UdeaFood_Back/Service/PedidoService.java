package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.DTO.PedidoDTO;
import com.UdeaFood_Back.DTO.ProductoPedidoDTO;
import com.UdeaFood_Back.Modelo.*;
import com.UdeaFood_Back.Repository.IPedidoRepository;
import com.UdeaFood_Back.Repository.IProductoRepository;
import com.UdeaFood_Back.Repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Transactional
@RequiredArgsConstructor
@Service
public class PedidoService {


    private final IPedidoRepository iPedidoRepository;

    private final IUsuarioRepository iUsuarioRepository;

    private final IProductoRepository iProductoRepository;

   // public Usuario getUsuarioById(Integer id){
        //return iUsuarioRepository.findById(id).orElse(null);
    //}

    public List<ProductoPedido> getProductosByPedidoId(Integer idPedido) {
        if (idPedido == null || idPedido <= 0) {
            throw new IllegalArgumentException("El ID del pedido no puede ser nulo o negativo");
        }
        Pedido pedido = iPedidoRepository.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + idPedido));
        return pedido.getProductoPedidos();
    }

    public Pedido crearPedido(PedidoDTO pedidoDTO){
        Usuario usuario = iUsuarioRepository.findById(pedidoDTO.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setFecha(new Date());

        List<ProductoPedido> productoPedidos = new ArrayList<>();

        for (ProductoPedidoDTO ppDTO : pedidoDTO.getProductos()){
            Producto producto = iProductoRepository.findById(ppDTO.getProductoId())
                    .orElseThrow(()->new RuntimeException("Producto no encontrado" + ppDTO.getProductoId()));

            ProductoPedidoId productoPedidoId = new ProductoPedidoId(producto.getId(), null);

            ProductoPedido productoPedido = new ProductoPedido();
            productoPedido.setId(productoPedidoId);
            productoPedido.setProducto(producto);
            productoPedido.setPedido(pedido);
            productoPedido.setCantidad(ppDTO.getCantidad());
            productoPedido.setPrecioUnitario(ppDTO.getPrecioUnitario());

            productoPedidos.add(productoPedido);

        }
        pedido.setProductoPedidos(productoPedidos);
        Pedido pedidoGuardado = iPedidoRepository.save(pedido);
        for(ProductoPedido pp: pedidoGuardado.getProductoPedidos()){
            pp.getId().setPedido(pedidoGuardado.getId());
        }
        return iPedidoRepository.save(pedidoGuardado);
    }



    public Integer getPedidoIdPorUsuarioYProducto(Integer idUsuario, Integer idProducto) {

        Usuario usuario = iUsuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario con id: " + idUsuario + " no encontrado"));

        Producto producto = iProductoRepository.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("Producto con id: " + idProducto + " no encontrado"));

        // Busca el pedido del usuario que contiene el producto
        Pedido pedido = usuario.getPedidos().stream()
                .filter(p -> p.getProductoPedidos().stream()
                        .anyMatch(pp -> pp.getProducto().getId().equals(idProducto)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No se encontró un pedido del usuario con el producto especificado"));

        return pedido.getId();
    }

}
