package br.com.empiricus.service;
//BY THIAGOSILVA
import java.util.List;

import br.com.empiricus.model.ClientePJ;

public interface ClientePJService {
	ClientePJ saveClientePJ(ClientePJ clientePJ);//METODO  POST
	List<ClientePJ> getAllClientesPJ(); //METODO GET ALL (PESQUISA TODA TABELO)
	ClientePJ getClientePJById(long id); //METODO GET POR ID
	ClientePJ updateClientePJ(ClientePJ clientePJ, long id); //METODO PUT 
	void deleteClientePJ(long id); //METODO DELETE
}
