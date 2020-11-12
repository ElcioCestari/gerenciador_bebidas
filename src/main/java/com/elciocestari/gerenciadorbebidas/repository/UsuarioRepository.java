package com.elciocestari.gerenciadorbebidas.repository;

import com.elciocestari.gerenciadorbebidas.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Faz operações de banco
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
