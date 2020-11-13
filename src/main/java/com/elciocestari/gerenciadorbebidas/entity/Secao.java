package com.elciocestari.gerenciadorbebidas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * Entidade que representa as seções onde serão armazenadas as bebidas
 */
public class Secao {

    @Column(name = "secao_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Bebida> bebida;
}
