package com.ies.guiaelectrica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ies.guiaelectrica.models.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
