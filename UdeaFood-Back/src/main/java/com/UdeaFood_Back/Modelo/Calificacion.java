package com.UdeaFood_Back.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "calificacion")
@Getter
@Setter
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "calificacion", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer calificacion;

    @Column(name="comentario", length = 1000)
    private String comentario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fecha;


    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto_pedido", nullable = false, unique = true)
    private ProductoPedido productoPedido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto", referencedColumnName = "id", nullable = false)
    Producto producto;
}
