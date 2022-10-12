package br.com.empiricus.service;

public interface CalculaIndicadores {

	private Double pl = precoAcao / lucroPorAcao;
	
	private Double roe = (lucroLiquido / patrimonioLiquido) x 100;
	
	private Double pvp = precoAcao / valorPatrimonialPorAcao;
	
	private Double evebitda = (cotacaoAcao*acoesTotais) + dividaTotal – CaixaEEquivalentes;

	private Double dividendYield = dividendo / precoAcao;
	
	private Double lpa = lucroLiquido / acoesTotais;
	
	private Double margemLiquida = (lucroLiquido / receitaLiquida) * 100;
	
}