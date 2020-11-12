package com.elciocestari.gerenciadorbebidas.repository;

import com.elciocestari.gerenciadorbebidas.entity.Secao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SecaoRepository extends JpaRepository<Secao, Long> {


    // a query precisa ser algo assim
    //select *, sum(bebida.volume) from secao JOIN bebida ON secao.id = bebida.fk_secao where secao.id = 1 group by secao.nome ;
    //@Query("SELECT S, SUM(volume)  FROM Secao as S JOIN bebida ON S.id = Bebida.bebida_id WHERE id = 1")
    //Secao sumVolumeFromSecao();
}
