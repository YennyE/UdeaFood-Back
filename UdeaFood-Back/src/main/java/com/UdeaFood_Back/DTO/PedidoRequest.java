package com.UdeaFood_Back.DTO;

import com.UdeaFood_Back.Modelo.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {
    private Integer idUsuario;
    private Double total;
    private Date fecha;
    private List<Integer> productos;
}
