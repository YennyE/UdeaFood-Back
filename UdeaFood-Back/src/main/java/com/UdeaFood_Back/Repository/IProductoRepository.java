package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{
}
