package br.com.empiricus.APIIndicAtivo.repository;

import br.com.empiricus.APIIndicAtivo.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    public List<Cadastro> findAllByCpf(String cpf);
}
