package br.com.empiricus.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.empiricus.model.ClientePJ;
import br.com.empiricus.model.UserLoginPJ;
import br.com.empiricus.service.UsuarioPJService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioPJController {
	
	@Autowired
	private UsuarioPJService usuarioPJService;

	@PostMapping("/logar/cnpj")
	public ResponseEntity<UserLoginPJ> Autentication(@RequestBody Optional<UserLoginPJ> user){
		return usuarioPJService.Logar(user)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity
				.status(HttpStatus.UNAUTHORIZED)
				.build());
	}

	//--> Aqui adicionamos um Optional de usuarios que estava trazendo valores nulos
	@PostMapping("/cadastrar/cnpj")
	public ResponseEntity<ClientePJ> Post(@RequestBody ClientePJ clientePJ) {
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(usuarioPJService.CadastrarUsuarioPJ(clientePJ));
	}	

}
