package com.elciocestari.gerenciadorbebidas.repository;

import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BebidaRepository extends JpaRepository<Bebida, Long> {

}
