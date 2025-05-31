package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.DTO.PedidoDTO;
import com.UdeaFood_Back.DTO.ProductoPedidoDTO;
import com.UdeaFood_Back.Modelo.*;
import com.UdeaFood_Back.Repository.IPedidoRepository;
import com.UdeaFood_Back.Repository.IProductoRepository;
import com.UdeaFood_Back.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class PedidoService {

    @Autowired
    private IPedidoRepository iPedidoRepository;
    @Autowired
    private IUsuarioRepository iUsuarioRepository;
    @Autowired
    private IProductoRepository iProductoRepository;

   // public Usuario getUsuarioById(Integer id){
        //return iUsuarioRepository.findById(id).orElse(null);
    //}

    public Pedido crearPedido(PedidoDTO pedidoDTO){
        Usuario usuario = iUsuarioRepository.findById(pedidoDTO.getUsuarioId())
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

}
