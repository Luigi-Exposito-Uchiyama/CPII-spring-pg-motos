package br.com.fiap.motos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_VEICULO")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VEICULO")
    @SequenceGenerator(name = "SQ_VEICULO", sequenceName = "SQ_VEICULO", allocationSize = 1)
    @Column(name = "ID_VEICULO")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "ANO")
    private Year anoDeFabricacao;

    @Column(name = "COR")
    private String cor;

    @Column(name = "PRECO")
    private Double preco;

    @Column(name = "CC")
    private Short cilindradas;

    @Column(name = "MODELO")
    private String modelo;

    //15 digitos
    @Column(name = "PALAVRA_DE_EFEITO")
    private String palavraDeEfeito;

    private Fabricante fabricante;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "TIPO_VEICULO",
            referencedColumnName = "ID_TIPO_VEICULO",
            foreignKey = @ForeignKey(name = "FK_VEICULO_TIPO_VEICULO")
    )
    private TipoVeiculo tipo;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ACESSORIO",
            referencedColumnName = "ID_ACESSORIO",
            foreignKey = @ForeignKey(name = "FK_VEICULO_ACESSORIO")
    )
    private Set<Acessorio> acessorios = new LinkedHashSet<>();
}
