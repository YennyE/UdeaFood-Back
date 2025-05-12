package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICalificacionRepository extends JpaRepository<Calificacion, Integer> {

    boolean existsByProductoPedido_Id(Integer idProductoPedido);
    List<Calificacion> findAllByProducto_Id(Integer idProducto);

}
