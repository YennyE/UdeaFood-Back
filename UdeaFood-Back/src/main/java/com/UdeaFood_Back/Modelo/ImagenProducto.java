package com.UdeaFood_Back.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "imagen_producto")
@Getter
@Setter
public class ImagenProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "imagen", columnDefinition = "LONGBLOB")
    private byte[] imagen; // Se guarda la imagen en formato BLOB

    @OneToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @JsonBackReference
    private Producto producto;

}
