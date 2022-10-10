package br.com.empiricus.model;
//BY THIAGOSILVA
import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name="clientes")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(unique = true)
	private String cnpj;

	@NotNull
	private String nome;

	@NotNull
	private String sobrenome;

	@NotNull
	private String email;

	

}
