package com.elciocestari.gerenciadorbebidas.repository;

import com.elciocestari.gerenciadorbebidas.dto.CustomResponseDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.entity.Secao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Faz operações de banco
 */
public interface SecaoRepository extends JpaRepository<Secao, Long> {

//    @Query("SELECT Secao.nome, Secao.bebida FROM Secao")
//    List<CustomResponseDTO> getVolumeById();
}
