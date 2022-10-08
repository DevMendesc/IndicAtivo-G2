package br.com.empiricus.service;


import br.com.empiricus.model.Ativos;

import java.util.List;

public interface AtivosService {

    Ativos saveAtivos(Ativos ativos);//METODO  POST
    List<Ativos> getAllAtivos(); //METODO GET ALL (PESQUISA TODA TABELO)
    Ativos getAtivosById(long id); //METODO GET POR ID
    Ativos updateAtivos(Ativos cliente, long id); //METODO PUT
    void deleteAtivos(long id); //METODO DELETE
}
