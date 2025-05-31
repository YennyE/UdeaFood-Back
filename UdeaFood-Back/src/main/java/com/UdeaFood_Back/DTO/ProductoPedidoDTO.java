package com.UdeaFood_Back.DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoPedidoDTO {
    private Integer productoId;
    private Integer cantidad;
    private Double precioUnitario;
}
