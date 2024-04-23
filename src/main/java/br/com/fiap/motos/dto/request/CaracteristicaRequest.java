package br.com.fiap.motos.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CaracteristicaRequest(

        @Valid
        @NotNull(message = "O atributo veiculo é obrigatório")
        AbstractRequest veiculo,

        @NotNull(message = "O atributo nome é obrigatório")
        String nome,

        @NotNull(message = "O atributo descricao é obrigatório")
        String descricao
) {

}
