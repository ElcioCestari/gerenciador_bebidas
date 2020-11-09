package com.elciocestari.gerenciadorbebidas.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
public class BebidaAlcoolica extends Bebida {

    BebidaAlcoolica(Long id, Double preco, String nome, Double volume, String tipo) {
        super(id, preco, nome, volume, tipo);
    }
}
