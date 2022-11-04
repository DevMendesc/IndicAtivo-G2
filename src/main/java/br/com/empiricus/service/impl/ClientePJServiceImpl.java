package br.com.empiricus.service.impl;


//BY THIAGOSILVA
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.empiricus.model.ClientePJ;
import br.com.empiricus.repository.ClientePJRepository;
import br.com.empiricus.service.ClientePJService;
import br.com.empiricus.springboot.exception.ResourceNotFoundException;


@Service
@Transactional
public class ClientePJServiceImpl implements ClientePJService {

	private ClientePJRepository clientePJRepository;
	
	public ClientePJServiceImpl(ClientePJRepository clientePJRepository) {
		super();
		this.clientePJRepository = clientePJRepository;
	}


	@Override
	public ClientePJ saveClientePJ(ClientePJ cliente) {
		return clientePJRepository.save(cliente);
	}


	@Override
	public java.util.List<ClientePJ> getAllClientesPJ() {
		return clientePJRepository.findAll();
	}


	@Override
	public ClientePJ getClientePJById(long id) {
		return clientePJRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Cliente", "Id", id));
	}


	@Override
	public ClientePJ updateClientePJ(ClientePJ clientePJ, long id) {
		// VERIFICAR SE O ID EXISTE DENTRO DO BD
		ClientePJ existingClientePJ = clientePJRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Cliente", "Id", id));
		
		existingClientePJ.setTelefone(clientePJ.getTelefone());	
		existingClientePJ.setNome(clientePJ.getNome());
		existingClientePJ.setEmail(clientePJ.getEmail());
		existingClientePJ.setCnpj(clientePJ.getCnpj());
		//SALVAR FUNCIONARIO EXISTENTE NO BD
		clientePJRepository.save(existingClientePJ);
		return existingClientePJ;
		
		
	}
	
	

	@Override
	public void deleteClientePJ(long id) {
		// VERIFICAR SE O ID EXISTE DENTRO DO BD
		clientePJRepository.findById(id).orElseThrow(() -> 
							new ResourceNotFoundException("Cliente", "Id", id));
		clientePJRepository.deleteById(id);
		
	}
	
	
	
}
