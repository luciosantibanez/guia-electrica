package com.ies.guiaelectrica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ies.guiaelectrica.models.Normativa;

import java.util.List;

public interface NormativaRepository extends JpaRepository<Normativa, Long> {
    List<Normativa> findByMunicipioContainingIgnoreCase(String municipio);
}
