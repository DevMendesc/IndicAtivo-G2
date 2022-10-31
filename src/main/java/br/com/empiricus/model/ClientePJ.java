package br.com.empiricus.model;
//BY THIAGOSILVA
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="clientes_pj")
public class ClientePJ {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "nome", nullable = false )
	private String nome;
	
	@NotNull
	private String email;
	
	@NotNull
	@Column(name = "cnpj", unique = true)
	@Size(min=14, max=14)
	private String cnpj;
	
	@NotNull
	@Column(name = "telefone")
	private String telefone;

	@NotNull
	@Size(min = 6, max = 100)
	private String senha;
}
