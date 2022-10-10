package br.com.empiricus.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.empiricus.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

   public List<Cliente> findByNomeContainingIgnoreCase(String nome);
   public List<Cliente> findByEmailContainingIgnoreCase(String email);
   public List<Cliente> findBySobrenomeContainingIgnoreCase(String sobrenome);
   public List<Cliente> findByCnpj(String cnpj);
}
