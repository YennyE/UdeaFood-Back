package com.UdeaFood_Back.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CalificacionRequest {
    private Integer idUsuario;
    private Integer idProducto;
    private Integer idPedido;
    private Integer calificacion;
    private String comentario;
}
