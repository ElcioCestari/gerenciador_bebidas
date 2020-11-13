package com.elciocestari.gerenciadorbebidas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * Fará a validação dos campos que serao inseridos na entidade de mesmo nome
 */
public class SecaoDTO {

    private Long id;

    @NotBlank
    private String nome;

    @Valid
    private List<BebidaDTO> bebida;
}
