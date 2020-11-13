package com.elciocestari.gerenciadorbebidas.dto;

import com.elciocestari.gerenciadorbebidas.entity.Bebida;
import com.elciocestari.gerenciadorbebidas.entity.Secao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponseDTO {

    private String secaoNome;
    private Bebida bebidaNome;

}
