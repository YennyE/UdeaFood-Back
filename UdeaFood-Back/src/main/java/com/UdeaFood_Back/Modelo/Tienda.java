package com.UdeaFood_Back.Modelo;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "Tienda")
@Data
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    @NotNull
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "ubicacion")
    private String ubicacion;
    @Column(name = "foto")
    private String foto;
    @Column(name = "correo")
    @NotNull
    private String correo;
    @Column(name = "usuario")
    @NotNull
    private String usuario;
    @NotNull
    @Column(name = "clave")
    private String clave;

    @Column(name = "domicilio")
    @NotNull
    private Character domicilio;
    @Column(name = "contacto")
    private String contacto;
}
