package com.UdeaFood_Back.Modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "Tienda")
@Data
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre",nullable = false, unique = true)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "foto")
    private String foto;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "usuario", nullable = false, unique = true)
    private String usuario;

    @Column(name = "clave", nullable = false)
    private String clave;

    @Column(name = "domicilio", nullable = false)
    private Character domicilio;

    @Column(name = "contacto")
    private String contacto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_tienda", nullable = false)
    private TipoTienda tipoTienda;

    @OneToMany(mappedBy = "idTienda", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Seccion> secciones;


}
