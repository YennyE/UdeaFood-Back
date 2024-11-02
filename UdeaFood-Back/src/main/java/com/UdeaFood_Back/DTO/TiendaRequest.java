package com.UdeaFood_Back.DTO;

import com.UdeaFood_Back.Modelo.TipoTienda;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TiendaRequest {

    private String nombre;
    private String descripcion;
    private String ubicacion;
    private byte[] foto;
    private String correo;
    private String usuario;
    private String clave;
    private Character domicilio;
    private String contacto;
    private TipoTienda tipoTienda;
}
