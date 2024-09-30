package com.UdeaFood_Back.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "Seccion")
@Getter
@Setter
public class Seccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tienda", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Tienda idTienda;


    @Column(name = "nombre",nullable = false)
    private String nombre;



    // Cambiamos mappedBy a "seccion" porque es el atributo en Producto
    @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Producto> productos;
}
