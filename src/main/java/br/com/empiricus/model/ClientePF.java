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
@Table(name = "clientes_pf")
public class ClientePF {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "nome", nullable = false)
	private String Nome;

	@NotNull
	@Column(name = "sobreNome")
	private String SobreNome;

	@NotNull
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "cpf", unique = true)
	@Size(min = 11, max = 11)
	private String cpf;
	
	@NotNull
	@Size(min = 6, max = 100)
	private String senha;

	@NotNull
	@Column(name = "telefone")
	private String telefone;
}
