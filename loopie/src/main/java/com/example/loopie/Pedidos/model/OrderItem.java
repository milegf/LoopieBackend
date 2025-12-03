package com.example.loopie.Pedidos.model;

import com.example.loopie.Products.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItemPedido;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedidoItem;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productItem;

    private Integer cantidad;

    private Double precioItem;
}
