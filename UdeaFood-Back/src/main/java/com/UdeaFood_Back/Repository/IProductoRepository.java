package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{

    List<Producto> findAllByNombreContaining(String nombre);
    //List<Producto> findAllByNombreCategoria(String nombreCategoria);
    //List<Producto> findAllByCategoriasNombreCategoriaContaining(String nombreCategoria);
}
