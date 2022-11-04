package br.com.empiricus.service;




import br.com.empiricus.model.Ativos;

import java.util.List;

public interface AtivosService {


    List<Ativos> getAllAtivos();
    List<Ativos> getAtivosByNome(String nome);
    Ativos getAtivosById(long id);
    Ativos saveAtivos(Ativos ativos);
    Ativos updateAtivos(Ativos cliente, long id);
    void deleteAtivos(long id);
}
