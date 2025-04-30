package com.UdeaFood_Back.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
}
