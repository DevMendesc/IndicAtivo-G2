package br.com.empiricus.APIIndicAtivo.controller;

import br.com.empiricus.APIIndicAtivo.model.Ativos;
import br.com.empiricus.APIIndicAtivo.repository.AtivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ativo")
public class AtivosController {
    @Autowired
    private AtivosRepository ativosRepository;

    @GetMapping
    public ResponseEntity<List<Ativos>> GetAll (){
        return ResponseEntity.ok(ativosRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ativos> GetById (@PathVariable Long id){
        return ResponseEntity.ok(ativosRepository.findById(id).orElse(null));
    }

    @PostMapping
    public ResponseEntity<Ativos> Create (Ativos ativos){
        ativosRepository.save(ativos);
        return ResponseEntity.ok(ativos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ativos> Update (Ativos ativos){
        ativosRepository.save(ativos);
        return ResponseEntity.ok(ativos);
    }


}
