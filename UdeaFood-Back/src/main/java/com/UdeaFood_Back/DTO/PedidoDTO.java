package com.UdeaFood_Back.DTO;

import com.UdeaFood_Back.Modelo.ProductoPedido;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public class PedidoDTO {
    private Integer UsuarioId;
    private Double total;
    private List<ProductoPedidoDTO> productos;
}
