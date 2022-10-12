package br.com.empiricus.service.impl;

import br.com.empiricus.model.Indicadores;
import br.com.empiricus.repository.IndicadoresRepository;
import br.com.empiricus.service.IndicadoresService;
import br.com.empiricus.springboot.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IndicadoresServiceImpl implements IndicadoresService {

    private IndicadoresRepository indicadoresRepository;

    public IndicadoresServiceImpl(IndicadoresRepository indicadoresRepository) {
        super();
        this.indicadoresRepository = indicadoresRepository;
    }


    @Override
    public Indicadores saveIndicadores(Indicadores indicadores) {
        return indicadoresRepository.save(indicadores);
    }


    @Override
    public java.util.List<Indicadores> getAllIndicadores() {
        return indicadoresRepository.findAll();
    }

    @Override
    public List<Indicadores> getIndicadoresByNome(String nome) {
        return indicadoresRepository.findByNomeContainingIgnoreCase(nome);
    }


    @Override
    public Indicadores getIndicadoresById(long id) {
        return indicadoresRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Indicadores", "Id", id));
    }




    @Override
    public Indicadores updateIndicadores(Indicadores indicadores, long id) {

        Indicadores existingindicadores = indicadoresRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("indicadores", "Id", id));

        existingindicadores.setNome(indicadores.getNome());
        existingindicadores.setPlResult(indicadores.getPlResult());
        existingindicadores.setRoeResult(indicadores.getRoeResult());
        existingindicadores.setPvpResult(indicadores.getPvpResult());
        existingindicadores.setEvebitdaResult(indicadores.getEvebitdaResult());
        existingindicadores.setDividendYieldResult(indicadores.getDividendYieldResult());
        existingindicadores.setLpaResult(indicadores.getLpaResult());
        existingindicadores.setMargemLiquidaResult(indicadores.getMargemLiquidaResult());
        
        
        indicadoresRepository.save(existingindicadores);
        return existingindicadores;


    }


    @Override
    public void deleteIndicadores(long id) {

        indicadoresRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Indicadores", "Id", id));
        indicadoresRepository.deleteById(id);

    }


	@Override
	public void deleteIndicadores(String nome) {
		  indicadoresRepository.findByNome(nome).orElseThrow(() ->
          new ResourceNotFoundException("Indicadores", "Nome", nome));
  indicadoresRepository.deleteByNome(nome);
		
	}


}
