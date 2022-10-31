package br.com.empiricus.controller;

//BY THIAGOSILVA
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empiricus.model.ClientePJ;
import br.com.empiricus.service.ClientePJService;

@RestController
@RequestMapping("/api/clientespj")
public class ClientePJController {
	
	private ClientePJService clientePJService;

	public ClientePJController(ClientePJService clientePJService) {
		super();
		this.clientePJService = clientePJService;
	}
	
	
	//CRIAÇÃO DE INSERÇÃO API REST CLIENTE
	//http://localhost:8080/api/clientesPJ
	@PostMapping()
	public ResponseEntity<ClientePJ> saveCliente(@RequestBody ClientePJ clientePJ){
		return new ResponseEntity<ClientePJ>(clientePJService.saveClientePJ(clientePJ), HttpStatus.CREATED);
		
	}
	
	//CRIAÇÃO DE BUSCA API REST CLIENTE
	//http://localhost:8080/api/clientes/
	@GetMapping
	public List<ClientePJ> getAllClientesPJ(){
		return clientePJService.getAllClientesPJ();
	}
	
	//CRIAÇÃO DE BUSCA POR ID API REST CLIENTE
	//http://localhost:8080/api/clientes/1
	@GetMapping("{id}")
	public ResponseEntity<ClientePJ> getClientePJById(@PathVariable("id") long clientePJid){
		return new ResponseEntity<ClientePJ>(clientePJService.getClientePJById(clientePJid), HttpStatus.OK);
	}
	
	//CRIAÇÃO DE ATUALIZAÇÃO API REST CLIENTE
	//http://localhost:8080/api/clientes/1
	@PutMapping("{id}")
	public ResponseEntity<ClientePJ> updateClientePJ(@PathVariable("id") long id
												,@RequestBody ClientePJ clientePJ){
		return new ResponseEntity<ClientePJ>(clientePJService.updateClientePJ(clientePJ, id), HttpStatus.OK);
	}
	
	//CRIAÇÃO DO DELETE API REST CLIENTE
	//http://localhost:8080/api/clientes/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteClientePJ(@PathVariable("id") long id){
		//DELETANDO DO BD
		clientePJService.deleteClientePJ(id);
		return new ResponseEntity<String>("Cliente Deletado com sucesso!.", HttpStatus.OK);
	}
	
	
	
}
