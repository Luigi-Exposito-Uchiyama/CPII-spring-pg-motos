package br.com.fiap.motos.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.Year;


public record VeiculoRequest (

        @NotNull(message = "O atributo preco é obrigatório")
        Double preco,

        @NotNull(message = "O atributo modelo é obrigatório")
        String modelo,

        @NotNull(message = "O atributo ano de fabricante é obrigatório")
        Year anoDeFabricante,

        @NotNull(message = "O atributo nome é obrigatório")
        String nome,

        @Valid
        @NotNull(message = "O atributo Tipo é obrigatório")
        AbstractRequest tipo,

        @Valid
        @NotNull(message = "O atributo fabricante é obrigatório")
        AbstractRequest fabricante,

        @NotNull(message = "O atributo cor é obrigatório")
        String cor,

        @NotNull(message = "O atributo palavra de efeito é obrigatório")
        String palavraDeEfeito,

        @NotNull(message = "O atributo cilindradas é obrigatório")
        Short cilindradas
) {
}