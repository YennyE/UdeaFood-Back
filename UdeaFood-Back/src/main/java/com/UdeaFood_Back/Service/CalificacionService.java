package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.DTO.CalificacionRequest;
import com.UdeaFood_Back.DTO.CalificacionResponse;
import com.UdeaFood_Back.Modelo.Calificacion;
import com.UdeaFood_Back.Modelo.Pedido;
import com.UdeaFood_Back.Modelo.ProductoPedido;
import com.UdeaFood_Back.Modelo.Usuario;
import com.UdeaFood_Back.Repository.ICalificacionRepository;
import com.UdeaFood_Back.Repository.IProductoPedidoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class CalificacionService {

    private final ICalificacionRepository iCalificacionRepository;
    private final IProductoPedidoRepository iProductoPedidoRepository;



    public List<CalificacionResponse> getCalificaciones(Integer idProducto){
        if (idProducto == null || idProducto <= 0) {
            throw new IllegalArgumentException("El ID del producto no puede ser nulo");
        }
        List<Calificacion> calificaciones = iCalificacionRepository.findAllByProducto_Id(idProducto);
        List<CalificacionResponse> calificacionResponses = calificaciones.stream().map(this::modelToResponse).toList();

        return calificacionResponses;
    }






    public CalificacionResponse calificar(CalificacionRequest calificacionRequest) {

        ProductoPedido productoPedido = iProductoPedidoRepository.findById(calificacionRequest.getIdProductoPedido())
                .orElseThrow(() -> new IllegalArgumentException("Compra de producto no encontrada"));


        Pedido pedido = productoPedido.getPedido();
        Usuario usuario = pedido.getUsuario();
        if (!usuario.getId().equals(calificacionRequest.getIdUsuario())) {
            throw new IllegalStateException("Este usuario no compró ese artículo");
        }


        if (iCalificacionRepository.existsByProductoPedido_Id( productoPedido.getId() )) {
            throw new IllegalStateException("Ya dejaste reseña para esta compra");
        }


        Calificacion nuevaCalificacion = new Calificacion();
        nuevaCalificacion.setCalificacion(calificacionRequest.getCalificacion());
        nuevaCalificacion.setComentario(calificacionRequest.getComentario());
        nuevaCalificacion.setProductoPedido(productoPedido);
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

        Usuario usuario = calificacion.getProductoPedido().getPedido().getUsuario();

        response.setIdUsuario(usuario.getId());
        response.setNombreUsuario(usuario.getNombre());
        return response;
    }





}
