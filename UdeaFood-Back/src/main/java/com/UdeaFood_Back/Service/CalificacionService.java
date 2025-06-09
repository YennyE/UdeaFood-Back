package com.UdeaFood_Back.Service;


import com.UdeaFood_Back.DTO.CalificacionRequest;
import com.UdeaFood_Back.DTO.CalificacionResponse;
import com.UdeaFood_Back.Modelo.*;
import com.UdeaFood_Back.Repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class CalificacionService {

    private final ICalificacionRepository iCalificacionRepository;
    private final IProductoPedidoRepository iProductoPedidoRepository;
    private final IUsuarioRepository iUsuarioRepository;
    private final IPedidoRepository iPedidoRepository;
    private final IProductoRepository iProductoRepository;


    public CalificacionResponse getCalificacionPorUsuario(Integer idUsuario, Integer idProducto) {
        Usuario usuario = iUsuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario con id: " + idUsuario + " no encontrado"));

        Producto producto = iProductoRepository.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("Producto con id: " + idProducto + " no encontrado"));

        // Busca el pedido del usuario que tiene el producto
        Pedido pedido = usuario.getPedidos().stream()
                .filter(p -> p.getProductoPedidos().stream()
                        .anyMatch(productoPedido -> productoPedido.getProducto().getId().equals(idProducto)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No se encontró un pedido del usuario con el producto especificado"));

        // Busca la calificación asociada al pedido y al producto
        Calificacion calificacion = iCalificacionRepository.findAllByProducto_Id(idProducto).stream()
                .filter(c -> c.getPedido().getId().equals(pedido.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No se encontró una calificación para el producto en el pedido del usuario"));

        return modelToResponse(calificacion);
    }

    public List<CalificacionResponse> getCalificaciones(Integer idProducto){
        if (idProducto == null || idProducto <= 0) {
            throw new IllegalArgumentException("El ID del producto no puede ser nulo");
        }
        List<Calificacion> calificaciones = iCalificacionRepository.findAllByProducto_Id(idProducto);
        List<CalificacionResponse> calificacionResponses = calificaciones.stream().map(this::modelToResponse).toList();

        return calificacionResponses;
    }






    public CalificacionResponse calificar(CalificacionRequest calificacionRequest) {

        Usuario usuario = iUsuarioRepository.findById(calificacionRequest.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario con id: "+calificacionRequest.getIdUsuario()+" no encontrada"));

        if(!usuario.getPedidos().stream().anyMatch(pedido -> pedido.getId().equals(calificacionRequest.getIdPedido()))) {
            throw new IllegalArgumentException("Usuario no tiene un pedido con id: "+calificacionRequest.getIdPedido());
        }

        Pedido pedido = iPedidoRepository.findById(calificacionRequest.getIdPedido())
                .orElseThrow(() -> new IllegalArgumentException("Pedido con id: "+calificacionRequest.getIdPedido()+" no encontrado"));

        ProductoPedido productoPedido = iProductoPedidoRepository.findById(new ProductoPedidoId(calificacionRequest.getIdProducto(), pedido.getId()))
                .orElseThrow(() -> new IllegalArgumentException("Compra de producto no encontrada"));


        if (!usuario.getId().equals(calificacionRequest.getIdUsuario())) {
            throw new IllegalStateException("Este usuario no compró ese artículo");
        }

        if (iCalificacionRepository.existsByProducto_IdAndPedido_Id(calificacionRequest.getIdProducto(), pedido.getId())) {
            throw new IllegalStateException("Ya dejaste reseña para esta compra");
        }


        Calificacion nuevaCalificacion = new Calificacion();
        nuevaCalificacion.setCalificacion(calificacionRequest.getCalificacion());
        nuevaCalificacion.setComentario(calificacionRequest.getComentario());
        nuevaCalificacion.setFecha(new Date());
        nuevaCalificacion.setPedido(pedido);
        nuevaCalificacion.setProducto(productoPedido.getProducto());


        Calificacion calificacionGuardada = iCalificacionRepository.save(nuevaCalificacion);

        return modelToResponse(calificacionGuardada);

    }



    private CalificacionResponse modelToResponse(Calificacion calificacion) {
        CalificacionResponse response = new CalificacionResponse();
        response.setId(calificacion.getId());
        response.setComentario(calificacion.getComentario());
        response.setCalificacion(calificacion.getCalificacion());
        response.setFecha(calificacion.getFecha());

        Usuario usuario = calificacion.getPedido().getUsuario();

        response.setIdUsuario(usuario.getId());
        response.setNombreUsuario(usuario.getNombre());
        return response;
    }



}
