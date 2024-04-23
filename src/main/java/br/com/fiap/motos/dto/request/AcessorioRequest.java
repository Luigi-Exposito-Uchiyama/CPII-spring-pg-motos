package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;

public record AcessorioRequest(

        @NotNull(message = "O atributo nome é obrigatório")
        String nome,

        @NotNull(message = "O atributo preco é obrigatório")
        Double preco
) {
}
