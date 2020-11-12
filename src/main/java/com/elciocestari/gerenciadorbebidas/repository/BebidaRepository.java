package com.elciocestari.gerenciadorbebidas.repository;

import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Faz operações basicas de banco.
 */
public interface BebidaRepository extends JpaRepository<Bebida, Long> {
}
