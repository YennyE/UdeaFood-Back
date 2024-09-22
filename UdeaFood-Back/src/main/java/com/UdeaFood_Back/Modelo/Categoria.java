package com.UdeaFood_Back.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Categoria")
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "nombre_categoria",nullable = false)
    private String nombreCategoria;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @ManyToMany(mappedBy = "categorias")
    @JsonBackReference
    private List<Producto> productos;

}
