package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.ImagenProducto;
import com.UdeaFood_Back.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IImagenRepository extends JpaRepository<ImagenProducto, Integer> {

    ImagenProducto findByProducto(Producto producto);
}
