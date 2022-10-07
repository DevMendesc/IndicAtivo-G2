package br.com.empiricus.APIIndicAtivo.controller;

import br.com.empiricus.APIIndicAtivo.model.Clientes;
import br.com.empiricus.APIIndicAtivo.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
@CrossOrigin("*")
public class CadastroController {
    @Autowired
    private CadastroRepository repository;

    @GetMapping
    public ResponseEntity <List<Clientes>> GetAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Clientes> post(@RequestBody Clientes cadastro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cadastro));
    }


}
