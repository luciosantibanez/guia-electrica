package com.ies.guiaelectrica.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Normativa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String municipio;
    private String provincia;
    @Column(length = 2000)
    private String descripcion;
    private String pdfUrl;
}
