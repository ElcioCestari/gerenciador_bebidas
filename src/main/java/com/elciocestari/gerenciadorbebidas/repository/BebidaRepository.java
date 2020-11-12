package com.elciocestari.gerenciadorbebidas.repository;

import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BebidaRepository extends JpaRepository<Bebida, Long> {

    //TODO abandonar essa implementacao, fazer no braco mesmo kk
    @Query("SELECT B, SUM(volume) from Bebida as B where id = id_bebida ")
    Bebida sumVolumeFromBebidas();

}
