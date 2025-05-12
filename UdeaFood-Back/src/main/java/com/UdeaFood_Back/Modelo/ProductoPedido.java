package com.UdeaFood_Back.Modelo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Producto-Pedido")
@Getter
@Setter

public class ProductoPedido {

    @EmbeddedId
    private ProductoPedidoId id;


    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("producto")
    @JoinColumn(name = "id_Producto", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Producto producto;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("pedido")
    @JoinColumn(name = "id_Pedido", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Pedido pedido;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precioUnitario",nullable = false)
    private Double precioUnitario;


    @JsonManagedReference
    @OneToOne(mappedBy = "productoPedido", cascade = CascadeType.ALL)
    private Calificacion calificacion;





}
