package com.ies.guiaelectrica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ies.guiaelectrica.models.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
