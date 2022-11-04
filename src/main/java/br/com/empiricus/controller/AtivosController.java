package br.com.empiricus.controller;


import br.com.empiricus.model.Ativos;
import br.com.empiricus.service.AtivosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/Ativos")
public class AtivosController {

    private AtivosService ativosService;

    public AtivosController(AtivosService ativosService) {
        super();
        this.ativosService = ativosService;
    }

    @GetMapping
    public List<Ativos> getAllAtivos(){
        return ativosService.getAllAtivos();
    }


    @GetMapping("{id}")
    public ResponseEntity<Ativos> getAtivosById(@PathVariable long id){
        return new ResponseEntity<Ativos>(ativosService.getAtivosById(id), HttpStatus.OK);
    }


    @GetMapping("/nomes/{nome}")
    public ResponseEntity<List<Ativos>> getAtivosByNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(ativosService.getAtivosByNome(nome));
    }

    @PostMapping()
    public ResponseEntity<Ativos> saveAtivos(@RequestBody Ativos ativos){
        return new ResponseEntity<Ativos>(ativosService.saveAtivos(ativos), HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<Ativos> updateAtivos(@PathVariable("id") long id
            ,@RequestBody Ativos ativos){
        return new ResponseEntity<Ativos>(ativosService.updateAtivos(ativos, id), HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAtivos(@PathVariable("id") long id){

        ativosService.deleteAtivos(id);
        return new ResponseEntity<String>("Ativos Deletados!.", HttpStatus.OK);
    }


}
