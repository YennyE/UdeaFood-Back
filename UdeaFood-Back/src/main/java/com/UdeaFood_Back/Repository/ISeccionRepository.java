package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.Seccion;
import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Modelo.TipoTienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeccionRepository extends JpaRepository<Seccion, Integer> {


    List<Seccion> findAllByIdTienda(Tienda tienda);


    /*Hace un Join entre Seccion y Tienda para obtener
    los productos de un tipo de tienda(formal, informal)*/
    @Query("SELECT p FROM Seccion p "+
            "JOIN p.idTienda t "+
            "WHERE t.tipoTienda = :tipoTienda")
    List<Seccion> findAllProductByTipoTienda(@Param("tipoTienda") TipoTienda tipoTienda);
}
