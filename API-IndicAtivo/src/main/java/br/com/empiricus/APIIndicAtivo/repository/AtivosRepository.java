package br.com.empiricus.APIIndicAtivo.repository;

import br.com.empiricus.APIIndicAtivo.model.Ativos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtivosRepository extends JpaRepository <Ativos, Long> {
}
