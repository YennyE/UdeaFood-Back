package com.UdeaFood_Back.Modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre",nullable = false, unique = true)
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private Float precio;

    @Column(name = "disponibilidad", nullable = false)
    private String disponibilidad;

}
