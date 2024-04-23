package br.com.fiap.motos.dto.response;

import lombok.Builder;

import java.time.Year;

@Builder
public record VeiculoResponse(
        Double preco,

        String modelo,

        Year anoDeFabricante,

        String nome,

        TipoVeiculoResponse tipo,

        FabricanteResponse fabricante,

        String cor,

        String palavraDeEfeito,

        Short cilindradas,

        Long id

) {
}