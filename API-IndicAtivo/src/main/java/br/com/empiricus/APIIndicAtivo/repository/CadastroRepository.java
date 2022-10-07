package br.com.empiricus.APIIndicAtivo.repository;

import br.com.empiricus.APIIndicAtivo.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadastroRepository extends JpaRepository<Clientes, Long> {

    public List<Clientes> findAllByCpf(String cpf);
}
