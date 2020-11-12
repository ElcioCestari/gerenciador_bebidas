package com.elciocestari.gerenciadorbebidas.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
/**
 * Sera utilizada para mostrar mensagens para o usuário.
 */
public class MessageResponseDTO {
    private String message;
}
