package br.com.empiricus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "Ativos")
@AllArgsConstructor
@NoArgsConstructor
public class Ativos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long idCliente;

    @NotNull
    private String nome;

    @NotNull
    private Double lucro;

    @NotNull
    private Double acoesTotais;
    @NotNull
    private Double cotacaoAcao;
    @NotNull
    private Double precoAcao;
    @NotNull
    private Double valorPatrimonialPorAcao;
    @NotNull
    private Double impostos;
    @NotNull
    private Double taxasJuros;
    @NotNull
    private Double depreciacao;
    @NotNull
    private Double amortizacao;

    @NotNull
    private Double dividendos;
}
