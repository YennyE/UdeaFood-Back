package com.UdeaFood_Back.Modelo;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class ProductoPedidoId implements Serializable {
    private Integer producto;
    private Integer pedido;

    public ProductoPedidoId(){}

    public ProductoPedidoId(Integer producto, Integer pedido){
        this.producto = producto;
        this.pedido = pedido;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoPedidoId)) return false;
        ProductoPedidoId that = (ProductoPedidoId) o;
        return Objects.equals(producto, that.producto) &&
                Objects.equals(pedido, that.pedido);
    }
    @Override
    public int hashCode() {
        return Objects.hash(producto, pedido);
    }

}
