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


import br.com.empiricus.model.UserLoginPF;
import br.com.empiricus.model.ClientePF;
import br.com.empiricus.service.UsuarioPFService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioPFController {
	
	@Autowired
	private UsuarioPFService usuarioPFService;

	@PostMapping("/logar/cpf")
	public ResponseEntity<UserLoginPF> Autentication(@RequestBody Optional<UserLoginPF> user){
		return usuarioPFService.Logar(user)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity
				.status(HttpStatus.UNAUTHORIZED)
				.build());
	}

	//--> Aqui adicionamos um Optional de usuarios que estava trazendo valores nulos
	@PostMapping("/cadastrar/cpf")
	public ResponseEntity<ClientePF> Post(@RequestBody ClientePF clientePF) {
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(usuarioPFService.CadastrarUsuarioPF(clientePF));
	}	

}
