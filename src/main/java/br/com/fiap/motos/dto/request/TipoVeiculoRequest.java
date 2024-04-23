package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;

public record TipoVeiculoRequest(

        @NotNull(message = "O atributo nome é obrigatório")
        String nome
) {
}
