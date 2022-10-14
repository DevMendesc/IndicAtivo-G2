package br.com.empiricus.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.empiricus.entities.CalculaIndicadores;
//BY DEBORAPAIVA
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Indicadores")
@AllArgsConstructor
@NoArgsConstructor
public class Indicadores extends CalculaIndicadores {

	@ManyToOne
    private Cliente cliente;
	
	@ManyToOne
    private Ativos ativos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private String nome;
    
    
    //INDICADORES - Objetivo puxar as informações do entities - classe CalculandoIndicadores
    
    @NotNull
    private Double plResult;
    
    @NotNull
    private Double roeResult;
    
    @NotNull
    private Double pvpaResult;
   
    @NotNull
    private Double evResult;
   
    @NotNull
    private Double ebitdaResult;
    
    @NotNull
    private Double evebitdaResult;
    
    @NotNull
    private Double dividendYieldResult; 
    
    @NotNull
    private Double lpaResult;
    
    @NotNull
    private Double margemLiquidaResult;
    
}
