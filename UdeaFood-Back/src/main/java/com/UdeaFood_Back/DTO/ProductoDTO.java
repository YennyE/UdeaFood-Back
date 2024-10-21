package com.UdeaFood_Back.DTO;

import com.UdeaFood_Back.Modelo.Categoria;
import com.UdeaFood_Back.Modelo.Seccion;
import lombok.Getter;
import lombok.Setter;

import java.util.Base64;
import java.util.List;

@Getter
@Setter

public class ProductoDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Float precio;
    private String disponibilidad;

    private byte[] foto;

    private Seccion seccion;
    private List<Categoria> categoria;



    public ProductoDTO() {

    }

    public ProductoDTO(Integer id, String nombre, String descripcion, Float precio, String disponibilidad, byte[] foto, Seccion seccion, List<Categoria> categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.foto = foto;
        this.seccion = seccion;
        this.categoria = categoria;
    }

}
