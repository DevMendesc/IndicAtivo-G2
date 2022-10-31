package br.com.empiricus.service.impl;


//BY THIAGOSILVA
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.empiricus.model.ClientePF;
import br.com.empiricus.repository.ClientePFRepository;
import br.com.empiricus.service.ClientePFService;
import br.com.empiricus.springboot.exception.ResourceNotFoundException;


@Service
@Transactional
public class ClientePFServiceImpl implements ClientePFService {

	private ClientePFRepository clientePFRepository;
	
	public ClientePFServiceImpl(ClientePFRepository clientePFRepository) {
		super();
		this.clientePFRepository = clientePFRepository;
	}


	@Override
	public ClientePF saveClientePF(ClientePF clientePF) {
		return clientePFRepository.save(clientePF);
	}


	@Override
	public java.util.List<ClientePF> getAllClientesPF() {
		return clientePFRepository.findAll();
	}


	@Override
	public ClientePF getClientePFById(long id) {
		return clientePFRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Cliente", "Id", id));
	}


	@Override
	public ClientePF updateClientePF(ClientePF clientePF, long id) {
		// VERIFICAR SE O ID EXISTE DENTRO DO BD
		ClientePF existingClientePF = clientePFRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Cliente", "Id", id));
		
		existingClientePF.setNome(clientePF.getNome());	
		existingClientePF.setSobreNome(clientePF.getSobreNome());
		existingClientePF.setEmail(clientePF.getEmail());
		existingClientePF.setCpf(clientePF.getCpf());
		existingClientePF.setTelefone(clientePF.getTelefone());
		//SALVAR FUNCIONARIO EXISTENTE NO BD
		clientePFRepository.save(existingClientePF);
		return existingClientePF;
		
		
	}
	
	

	@Override
	public void deleteClientePF(long id) {
		// VERIFICAR SE O ID EXISTE DENTRO DO BD
		clientePFRepository.findById(id).orElseThrow(() -> 
							new ResourceNotFoundException("Cliente", "Id", id));
		clientePFRepository.deleteById(id);
		
	}
	
	
	
}
