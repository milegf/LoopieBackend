package com.example.loopie.Products.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Column(name = "descripcion")
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @Column(name = "precio")
    @NotBlank(message = "El precio no puede estar vacío")
    private double precio;

    @Column(name = "categoria")
    @NotBlank(message = "La categoría no puede estar vacía")
    private String categoria;

    @Column(name = "stock")
    @NotBlank(message = "El stock no puede estar vacío")
    private int stock;

    @Column(name = "imagen")
    @NotBlank(message = "La imagen no puede estar vacía")
    private String imagen;

    @Column(name = "enOferta")
    @NotBlank(message = "El estado de la oferta no puede estar vacío")
    private boolean enOferta;

    @Column(name = "precioOferta")
    @NotBlank(message = "El precio de la oferta no puede estar vacío")
    private double precioOferta;

    @Column(name = "tienda")
    @NotBlank(message = "La tienda no puede estar vacía")
    private String tienda;

    @Column(name = "talla")
    @NotBlank(message = "La talla no puede estar vacía")
    private String talla;

    @Column(name = "tag")
    @NotBlank(message = "El tag no puede estar vacío")
    private String tag;

    @Column(name = "isVintage")
    @NotBlank(message = "El estado de vintage no puede estar vacío")
    private boolean isVintage;
}
