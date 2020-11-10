package com.elciocestari.gerenciadorbebidas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BebidaDTO {

    private Long id;

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
