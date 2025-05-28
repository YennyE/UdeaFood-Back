package com.UdeaFood_Back.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CalificacionResponse {
    private Integer id;
    private Integer calificacion;
    private String comentario;
    private Date fecha;
    private Integer idUsuario;
    private String nombreUsuario;
}
