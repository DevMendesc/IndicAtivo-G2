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

import br.com.empiricus.model.ClientePF;
import br.com.empiricus.service.ClientePFService;

@RestController
@RequestMapping("/api/clientespf")
public class ClientePFController {
	
	private ClientePFService clientePFService;

	public ClientePFController(ClientePFService clientePFService) {
		super();
		this.clientePFService = clientePFService;
	}
	
	
	//CRIAÇÃO DE INSERÇÃO API REST CLIENTE
	//http://localhost:8080/api/clientes
	@PostMapping()
	public ResponseEntity<ClientePF> saveCliente(@RequestBody ClientePF clientePF){
		return new ResponseEntity<ClientePF>(clientePFService.saveClientePF(clientePF), HttpStatus.CREATED);
		
	}
	
	//CRIAÇÃO DE BUSCA API REST CLIENTE
	//http://localhost:8080/api/clientes/
	@GetMapping
	public List<ClientePF> getAllClientes(){
		return clientePFService.getAllClientesPF();
	}
	
	//CRIAÇÃO DE BUSCA POR ID API REST CLIENTE
	//http://localhost:8080/api/clientes/1
	@GetMapping("{id}")
	public ResponseEntity<ClientePF> getClienteById(@PathVariable("id") long clientePFid){
		return new ResponseEntity<ClientePF>(clientePFService.getClientePFById(clientePFid), HttpStatus.OK);
	}
	
	//CRIAÇÃO DE ATUALIZAÇÃO API REST CLIENTE
	//http://localhost:8080/api/clientes/1
	@PutMapping("{id}")
	public ResponseEntity<ClientePF> updateClientePF(@PathVariable("id") long id
												,@RequestBody ClientePF clientePF){
		return new ResponseEntity<ClientePF>(clientePFService.updateClientePF(clientePF, id), HttpStatus.OK);
	}
	
	//CRIAÇÃO DO DELETE API REST CLIENTE
	//http://localhost:8080/api/clientes/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteClientePF(@PathVariable("id") long id){
		//DELETANDO DO BD
		clientePFService.deleteClientePF(id);
		return new ResponseEntity<String>("Cliente Deletado com sucesso!.", HttpStatus.OK);
	}
	
	
	
}
