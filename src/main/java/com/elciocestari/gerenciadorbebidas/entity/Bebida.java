package com.elciocestari.gerenciadorbebidas.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Bebida {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double volume;
}
