package com.UdeaFood_Back.Modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Seccion")
@Getter
@Setter
public class Seccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "id_tienda",nullable = false)
    private Integer idTienda;


}
