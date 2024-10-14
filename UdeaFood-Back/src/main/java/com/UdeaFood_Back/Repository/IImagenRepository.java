package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.ImagenProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImagenRepository extends JpaRepository<ImagenProducto, Integer> {
}
