package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.ProductoPedido;
import com.UdeaFood_Back.Modelo.ProductoPedidoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoPedidoRepository extends JpaRepository<ProductoPedido, ProductoPedidoId> {
    // Puedes agregar métodos personalizados si los necesitas, por ejemplo:
    // List<ProductoPedido> findByPedidoId(Integer pedidoId);
}
