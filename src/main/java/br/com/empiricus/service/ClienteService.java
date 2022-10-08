package br.com.empiricus.service;
//BY THIAGOSILVA
import java.util.List;

import br.com.empiricus.model.Cliente;

public interface ClienteService {
	Cliente saveCliente(Cliente cliente);//METODO  POST
	List<Cliente> getAllClientes(); //METODO GET ALL (PESQUISA TODA TABELO)
	Cliente getClienteById(long id); //METODO GET POR ID
	Cliente updateCliente(Cliente cliente, long id); //METODO PUT 
	void deleteCliente(long id); //METODO DELETE
}
