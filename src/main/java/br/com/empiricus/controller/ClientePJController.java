package br.com.empiricus.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/Clientespj")
public class ClientePJController {

	@Autowired
	private ClientePJService clientePJService;


	@PostMapping()
	public ResponseEntity<ClientePJ> saveCliente(@RequestBody ClientePJ clientePJ){
		return new ResponseEntity<ClientePJ>(clientePJService.saveClientePJ(clientePJ), HttpStatus.CREATED);
		
	}

	@GetMapping
	public List<ClientePJ> getAllClientesPJ(){
		return clientePJService.getAllClientesPJ();
	}
	

	@GetMapping("{id}")
	public ResponseEntity<ClientePJ> getClientePJById(@PathVariable("id") long clientePJid){
		return new ResponseEntity<ClientePJ>(clientePJService.getClientePJById(clientePJid), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<ClientePJ> updateClientePJ(@PathVariable("id") long id
												,@RequestBody ClientePJ clientePJ){
		return new ResponseEntity<ClientePJ>(clientePJService.updateClientePJ(clientePJ, id), HttpStatus.OK);
	}
	

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteClientePJ(@PathVariable("id") long id){
		//DELETANDO DO BD
		clientePJService.deleteClientePJ(id);
		return new ResponseEntity<String>("Cliente Deletado com sucesso!.", HttpStatus.OK);
	}
	
	
	
}
