package br.com.empiricus.repository;
//BY THIAGOSILVA
import org.springframework.data.jpa.repository.JpaRepository;


import br.com.empiricus.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
