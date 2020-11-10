package com.elciocestari.gerenciadorbebidas.entity;


import javax.persistence.Entity;



@Deprecated
@Entity
public class BebidaAlcoolica extends Bebida {

    BebidaAlcoolica(Long id, Double preco, String nome, Double volume, String tipo) {
        super(id, preco, nome, volume, tipo);
    }
}
