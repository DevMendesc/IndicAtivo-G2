package br.com.empiricus.model;
//BY THIAGOSILVA
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false )
	private String Nome;
	
	@Column(name = "sobreNome")
	private String SobreNome;
	
	private String email;
	
	
	

}
