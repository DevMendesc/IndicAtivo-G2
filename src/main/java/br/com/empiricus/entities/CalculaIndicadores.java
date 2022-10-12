package br.com.empiricus.entities;

import br.com.empiricus.model.Ativos;

public class CalculaIndicadores extends Ativos {
	
	public void plResult(double pl) {
		double pl = getPrecoAcao() / getLucroPorAcao();
		//private Double pl = precoAcao / lucroPorAcao;
	}

	public void roeResult(double roe) {
		double roe = getLucroLiquido() / getPatrimonioLiquido() * 100;
		//private Double roe = (lucroLiquido / patrimonioLiquido) x 100;
	}
	
	public void pvpResult(double pvp) {
		double pvp = getPrecoAcao() / getValorPatrimonialPorAcao();
		//private Double pvp = precoAcao / valorPatrimonialPorAcao;
	}
	
	public void evebitdaResult(double evebitda) {
		double evebitda = (getCotacaoAcao() * getAcoesTotais()) + getDividaTotal() – getCaixaEEquivalentes();
		//private Double evebitda = (cotacaoAcao*acoesTotais) + dividaTotal – CaixaEEquivalentes;
	}

	public void dividendYieldResult(double dividendYield) {
		double dividendYield = getDividendo() / getPprecoAcao();
		//private Double dividendYield = dividendo / precoAcao;
	}
	
	public void lpaResult(double lpa) {
		double lpa = getLucroLiquido() / getAcoesTotais();
		//private Double lpa = lucroLiquido / acoesTotais;
	}
	
	public void margemLiquidaResult(double margemLiquida) {
		double margemLiquida = getLucroLiquido() / getReceitaLiquida()*100;
		//private Double margemLiquida = (lucroLiquido / receitaLiquida) * 100;
	}	
		
	
}