package br.com.empiricus.service.impl;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.empiricus.model.Cliente;
import br.com.empiricus.repository.ClienteRepository;
import br.com.empiricus.service.ClienteService;
import br.com.empiricus.springboot.exception.ResourceNotFoundException;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


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
	public List<Cliente> getClienteByNome (String nome) {
			return clienteRepository.findByNomeContainingIgnoreCase(nome);
	}

	public List<Cliente> getClienteBySobrenome (String sobrenome) {
		return clienteRepository.findBySobrenomeContainingIgnoreCase(sobrenome);
	}

	@Override
	public List<Cliente> getClienteByEmail(String email) {
		return clienteRepository.findByEmailContainingIgnoreCase(email);
	}



	@Override
	public Cliente getClienteById(long id) {
		return clienteRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Cliente", "Id", id));
	}

	@Override
	public List<Cliente> getClienteByCnpj(String cnpj) {
		return clienteRepository.findByCnpj(cnpj);
	}


	@Override
	public Cliente updateCliente(Cliente cliente, long id) {

		Cliente existingCliente = clienteRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Cliente", "Id", id));

		existingCliente.setCnpj(cliente.getCnpj());
		existingCliente.setNome(cliente.getNome());	
		existingCliente.setSobrenome(cliente.getSobrenome());
		existingCliente.setEmail(cliente.getEmail());

		clienteRepository.save(existingCliente);
		return existingCliente;
		
		
	}
	
	

	@Override
	public void deleteCliente(long id) {
		clienteRepository.findById(id).orElseThrow(() ->
							new ResourceNotFoundException("Cliente", "Id", id));
		clienteRepository.deleteById(id);
		
	}
	
	
	
}
