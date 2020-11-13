package com.elciocestari.gerenciadorbebidas.util.faker;

import com.elciocestari.gerenciadorbebidas.dto.BebidaDTO;
import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.enums.TipoBebida;

public class BebidaFake extends BebidaDTO {

    private Long id;
    private Double preco;
    private String nome;
    private Double volume;
    private String tipo;

    @Override
    public Long getId() {
        return id == null ? Long.valueOf(1) : this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Double getPreco() {
        return preco == null ? 22.45 : this.preco;
    }

    @Override
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String getNome() {
        return nome == null ? "skoll" : this.nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Double getVolume() {
        return volume == null ? 100.00 : this.volume;
    }

    @Override
    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Override
    public String getTipo() {
        return tipo == null ? TipoBebida.ALCOOLICA.toString() : this.tipo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
