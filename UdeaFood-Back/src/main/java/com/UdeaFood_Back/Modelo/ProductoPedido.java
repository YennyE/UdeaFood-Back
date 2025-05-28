package com.UdeaFood_Back.Modelo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto_pedido")
@Getter
@Setter

public class ProductoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precioUnitario",nullable = false)
    private Double precioUnitario;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Producto", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Producto producto;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Pedido", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Pedido pedido;


    @JsonManagedReference
    @OneToOne(mappedBy = "productoPedido", cascade = CascadeType.ALL)
    private Calificacion calificacion;





}
