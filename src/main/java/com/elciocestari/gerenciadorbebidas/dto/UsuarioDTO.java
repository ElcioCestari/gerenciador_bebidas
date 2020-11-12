package com.elciocestari.gerenciadorbebidas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * Fará a validação dos campos que serao inseridos na entidade de mesmo nome
 */
public class UsuarioDTO {

    private Long id;

    @NotBlank
    @Size(max = 256)
    private String login;

    @NotBlank
    @Size(max = 256)
    private String senha;
}
