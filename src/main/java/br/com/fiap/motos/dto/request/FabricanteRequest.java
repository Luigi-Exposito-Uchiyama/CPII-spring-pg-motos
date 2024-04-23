package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;

public record FabricanteRequest(

        @NotNull(message = "O atributo nome é obrigatório")
        String nome,

        @NotNull(message = "O atributo nome fantasia é obrigatório")
        String nomeFantasia
) {
}
