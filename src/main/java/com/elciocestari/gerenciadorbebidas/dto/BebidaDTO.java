package com.elciocestari.gerenciadorbebidas.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BebidaDTO {

    @NotBlank
    @Size(max = 256)
    private String nome;

    @NotNull
    private Double preco;

    @NotNull
    private Double volume;

    @NotNull
    @NotBlank
    private String tipo;

}
