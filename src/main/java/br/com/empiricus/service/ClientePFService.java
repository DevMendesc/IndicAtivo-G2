package br.com.empiricus.service;
//BY THIAGOSILVA
import java.util.List;

import br.com.empiricus.model.ClientePF;

public interface ClientePFService {
	ClientePF saveClientePF(ClientePF clientePF);//METODO  POST
	List<ClientePF> getAllClientesPF(); //METODO GET ALL (PESQUISA TODA TABELO)
	ClientePF getClientePFById(long id); //METODO GET POR ID
	ClientePF updateClientePF(ClientePF clientePF, long id); //METODO PUT 
	void deleteClientePF(long id); //METODO DELETE
	
}
