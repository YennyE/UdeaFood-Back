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



    @Column(name = "foto", columnDefinition = "LONGBLOB")
    private byte[] foto;


    @Column(name="calificacion")
    private Float calificacion;

    @Column(name="numero_calificaciones")
    private Integer numeroCalificaciones;



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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "id_horario", referencedColumnName = "id")
    @JsonManagedReference
    private Horario horario;

    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<MetodoPago> metodosPago;

}
