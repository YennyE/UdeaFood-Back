package com.UdeaFood_Back.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Producto")
@Getter
@Setter
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

    @Column(name = "disponibilidad")
    private String disponibilidad;


    //@Column(name = "foto", columnDefinition = "LONGBLOB")
    //private byte[] foto;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seccion", referencedColumnName = "id")
    @JsonBackReference
    private Seccion seccion;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "categoria_producto",
            joinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idCategoria", referencedColumnName = "id_categoria")
    )
    private List<Categoria> categorias;

    /*@OneToOne
    @JoinColumn(name = "foto", referencedColumnName = "id")
    private ImagenProducto foto;*/

    @OneToOne(mappedBy = "producto", fetch = FetchType.EAGER)
    @JsonManagedReference
    private ImagenProducto imagen;


}
