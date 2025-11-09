package com.ies.guiaelectrica.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Producto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;
    @Column(length = 2000)
    private String descripcion;
    private double precio;
    private double consumoWatts;
    private String imagenUrl;
    private String manualUrl;
}
