package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.ProductoPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductoPedidoRepository extends JpaRepository<ProductoPedido, Integer> {

    List<ProductoPedido> findByPedido_Usuario_Id(Integer idUsuario);
}
