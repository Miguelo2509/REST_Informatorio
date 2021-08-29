package com.informatorio.cart.repository;

import com.informatorio.cart.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Object findByFechaDeCreacionAfter(LocalDateTime atStartOfDay);

    Object findByNombreContainingAndApellidoContaining(String nombre, String apellido);
}
