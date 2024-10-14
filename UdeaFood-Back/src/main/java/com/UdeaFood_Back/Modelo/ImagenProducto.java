package com.UdeaFood_Back.Modelo;

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
    private byte[] imagen; // Aquí guardamos la imagen en formato BLOB

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id")

    private Producto producto;

}
