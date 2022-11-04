package br.com.empiricus.service.impl;


import br.com.empiricus.model.Ativos;
import br.com.empiricus.repository.AtivosRepository;
import br.com.empiricus.service.AtivosService;
import br.com.empiricus.springboot.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AtivosServiceImpl implements AtivosService {

    private AtivosRepository ativosRepository;

    public AtivosServiceImpl(AtivosRepository ativosRepository) {
        super();
        this.ativosRepository = ativosRepository;
    }


    @Override
    public Ativos saveAtivos(Ativos ativos) {
        return ativosRepository.save(ativos);
    }


    @Override
    public List<Ativos> getAllAtivos() {
        return ativosRepository.findAll();
    }

    @Override
    public List<Ativos> getAtivosByNome(String nome) {
        return ativosRepository.findByNomeContainingIgnoreCase(nome);
    }


    @Override
    public Ativos getAtivosById(long id) {
        return ativosRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Ativos", "Id", id));
    }




    @Override
    public Ativos updateAtivos(Ativos ativos, long id) {

        Ativos existingAtivos = ativosRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ativos", "Id", id));

        existingAtivos.setNome(ativos.getNome());
        existingAtivos.setLucroPorAcao(ativos.getLucroPorAcao());
        existingAtivos.setDividaTotal(ativos.getDividaTotal());
        existingAtivos.setCaixaEEquivalentes(ativos.getCaixaEEquivalentes());
        existingAtivos.setReceitaLiquida(ativos.getReceitaLiquida());
        existingAtivos.setLucroLiquido(ativos.getLucroLiquido());
        existingAtivos.setLucroOperacionalLiquido(ativos.getLucroOperacionalLiquido());
        existingAtivos.setAcoesTotais(ativos.getAcoesTotais());
        existingAtivos.setCotacaoAcao(ativos.getCotacaoAcao());
        existingAtivos.setPrecoAcao(ativos.getPrecoAcao());
        existingAtivos.setValorPatrimonialPorAcao(ativos.getValorPatrimonialPorAcao());
        existingAtivos.setPatrimonioLiquido(ativos.getPatrimonioLiquido());
        existingAtivos.setImpostos(ativos.getImpostos());
        existingAtivos.setJuros(ativos.getJuros());
        existingAtivos.setDepreciacao(ativos.getDepreciacao());
        existingAtivos.setAmortizacao(ativos.getAmortizacao());
        existingAtivos.setDividendo(ativos.getDividendo());


        ativosRepository.save(existingAtivos);
        return existingAtivos;


    }


    @Override
    public void deleteAtivos(long id) {

        ativosRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Ativos", "Id", id));
        ativosRepository.deleteById(id);

    }
}
