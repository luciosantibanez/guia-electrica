package com.ies.guiaelectrica.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Guia {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(length = 2000)
    private String descripcion;
    private String tipo;
    private String recursoUrl;
}
