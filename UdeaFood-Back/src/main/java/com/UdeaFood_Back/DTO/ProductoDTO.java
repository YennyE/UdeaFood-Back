package com.UdeaFood_Back.DTO;

import com.UdeaFood_Back.Modelo.Categoria;
import com.UdeaFood_Back.Modelo.Seccion;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class ProductoDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Float precio;
    private String disponibilidad;

    private ImagenProductoDTO imagen;

    private Seccion seccion;
    private List<Categoria> categorias;



    public ProductoDTO() {

    }

    public ProductoDTO(Integer id, String nombre, String descripcion, Float precio, String disponibilidad, ImagenProductoDTO imagen, Seccion seccion, List<Categoria> categorias) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.imagen = imagen;
        this.seccion = seccion;
        this.categorias = categorias;
    }

}
