package br.com.empiricus.service;

import java.util.List;

import br.com.empiricus.model.Cliente;

public interface ClienteService {
	Cliente saveCliente(Cliente cliente);
	List<Cliente> getAllClientes();
	List<Cliente> getClienteByNome(String nome);
	List<Cliente> getClienteBySobrenome(String sobrenome);
	List<Cliente> getClienteByEmail(String email);
	List<Cliente> getClienteByCnpj(String cnpj);
	Cliente getClienteById(long id);
	Cliente updateCliente(Cliente cliente, long id);
	void deleteCliente(long id);
}
