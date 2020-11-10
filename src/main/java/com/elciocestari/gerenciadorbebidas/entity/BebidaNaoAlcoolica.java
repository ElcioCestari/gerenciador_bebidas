package com.elciocestari.gerenciadorbebidas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Deprecated
@Entity
public class BebidaNaoAlcoolica extends Bebida{

    BebidaNaoAlcoolica(Long id, Double preco, String nome, Double volume, String tipo) {
        super(id, preco, nome, volume, tipo);
    }
}
