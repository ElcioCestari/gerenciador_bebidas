package com.elciocestari.gerenciadorbebidas.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Bebida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double volume;

    @Column(nullable = false)
    private String tipo;

    /*
    @ManyToOne
    @JoinColumn(name = "secao_id", insertable = true, updatable = true
    )*/
    //private Secao secao;
}
