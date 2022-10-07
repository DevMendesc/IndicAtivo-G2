package br.com.empiricus.APIIndicAtivo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

/*
*  @NotNull
    private  Double lucroPorAcao = lucro / acoesTotais; // LPA

    @NotNull
    private  Double ebitda = lucro + impostos + taxasJuros + depreciacao + amortizacao; // Ebitda

    @NotNull
    private  Double precoSobreValorPatrimonialPorAcao = precoAcao / valorPatrimonialPorAcao; // P/VPA

    @NotNull
    private  Double participacaoLucro = cotacaoAcao / lucroPorAcao; // P/L

    @NotNull
    private  Double valorMercado = cotacaoAcao * acoesTotais; // EV

    @NotNull
    private  Double rentabilidadeDividendos = dividendos / cotacaoAcao; // DY

    @NotNull
    private  Double dividendosPagos = dividendos / lucro; //DP

* */

}
