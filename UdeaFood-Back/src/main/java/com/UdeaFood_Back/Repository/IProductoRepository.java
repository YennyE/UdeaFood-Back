package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{

    List<Producto> findAllByNombreContaining(String nombre);
    //List<Producto> findAllByNombreCategoria(String nombreCategoria);
    //List<Producto> findAllByCategoriasNombreCategoriaContaining(String nombreCategoria);

    //para producto por tipo de tienda
    //@Query("SELECT p FROM Producto p JOIN p.seccion s JOIN s.tienda t WHERE t.tipoTienda = :tipoTienda")
    //List<Producto> findByTipoTienda(@Param(tipoTienda) String tipoTienda);
}
