package com.UdeaFood_Back.DTO;

import lombok.Data;

@Data
public class MetodoPagoDTO {

    private Integer id;
    private String tipo;
    private String detalles;
    private Integer idTienda;
}
