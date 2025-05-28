package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.Modelo.ProductoPedido;
import com.UdeaFood_Back.Repository.IProductoPedidoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductoPedidoService {
    private final IProductoPedidoRepository productoPedidoRepository;

    public List<ProductoPedido> obtenerIdPorIdUsuario(Integer idUsuario) {
        return productoPedidoRepository.findByPedido_Usuario_Id(idUsuario);
    }
}
