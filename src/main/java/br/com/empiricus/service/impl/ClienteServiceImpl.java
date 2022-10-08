package br.com.empiricus.service.impl;


//BY THIAGOSILVA
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.empiricus.model.Cliente;
import br.com.empiricus.repository.ClienteRepository;
import br.com.empiricus.service.ClienteService;
import br.com.empiricus.springboot.exception.ResourceNotFoundException;


@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository clienteRepository;
	
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}


	@Override
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}


	@Override
	public java.util.List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}


	@Override
	public Cliente getClienteById(long id) {
		return clienteRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Cliente", "Id", id));
	}


	@Override
	public Cliente updateCliente(Cliente cliente, long id) {
		// VERIFICAR SE O ID EXISTE DENTRO DO BD
		Cliente existingCliente = clienteRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Cliente", "Id", id));
		
		existingCliente.setNome(cliente.getNome());	
		existingCliente.setSobreNome(cliente.getSobreNome());
		existingCliente.setEmail(cliente.getEmail());
		//SALVAR FUNCIONARIO EXISTENTE NO BD
		clienteRepository.save(existingCliente);
		return existingCliente;
		
		
	}
	
	

	@Override
	public void deleteCliente(long id) {
		// VERIFICAR SE O ID EXISTE DENTRO DO BD
		clienteRepository.findById(id).orElseThrow(() -> 
							new ResourceNotFoundException("Cliente", "Id", id));
		clienteRepository.deleteById(id);
		
	}
	
	
	
}
