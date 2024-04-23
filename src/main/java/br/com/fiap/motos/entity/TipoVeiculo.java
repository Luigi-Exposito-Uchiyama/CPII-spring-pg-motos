package br.com.fiap.motos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_TIPO_VEICULO",

        uniqueConstraints = {

                @UniqueConstraint(
                        name = "UK_NOME_TIPO_VEICULO", columnNames = {"NOME"}
                )
        }

)
public class TipoVeiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_VEICULO")
    @SequenceGenerator(name = "SQ_TIPO_VEICULO", sequenceName = "SQ_TIPO_VEICULO", allocationSize = 1)
    @Column(name = "ID_TIPO_VEICULO")
    private Long id;

    @Column(name = "NOME")
    private String nome;
}
