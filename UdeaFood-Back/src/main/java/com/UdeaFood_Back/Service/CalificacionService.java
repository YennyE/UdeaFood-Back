package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.DTO.CalificacionRequest;
import com.UdeaFood_Back.Modelo.Calificacion;
import com.UdeaFood_Back.Modelo.Pedido;
import com.UdeaFood_Back.Modelo.ProductoPedido;
import com.UdeaFood_Back.Modelo.Usuario;
import com.UdeaFood_Back.Repository.ICalificacionRepository;
import com.UdeaFood_Back.Repository.IProductoPedidoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class CalificacionService {

    private final ICalificacionRepository iCalificacionRepository;
    private final IProductoPedidoRepository iProductoPedidoRepository;



    public List<Calificacion> getCalificaciones(Integer idProducto){
        return iCalificacionRepository.findAllByProducto_Id(idProducto);
    }






    public Calificacion calificar(CalificacionRequest calificacionRequest) {

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
        return iCalificacionRepository.save(nuevaCalificacion);

    }





}
