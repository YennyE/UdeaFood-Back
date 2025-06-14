package com.UdeaFood_Back.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private Integer idUsuario;
    private Double total;
    private List<ProductoPedidoDTO> productos;
}
