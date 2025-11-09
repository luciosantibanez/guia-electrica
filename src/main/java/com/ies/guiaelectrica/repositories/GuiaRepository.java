package com.ies.guiaelectrica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ies.guiaelectrica.models.Guia;

public interface GuiaRepository extends JpaRepository<Guia, Long> {}
