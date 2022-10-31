//package br.com.empiricus.controller;
//
//
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.empiricus.service.IndicadoresService;
//
//@RestController
//@RequestMapping ("/Indicadores")
//public class Indicadores {
//
//    private IndicadoresService indicadoresService;
//
//    public Indicadores(IndicadoresService indicadoresService) {
//        super();
//        this.indicadoresService = indicadoresService;
//    }
//
//    @GetMapping
//    public List<Indicadores> getAllIndicIndicadores(){
//        return IndicadoresService.getAllIndicadores();
//    }
//
//
//    @GetMapping("{id}")
//    public ResponseEntity<Indicadores> getIndicadoresById(@PathVariable long indicadoresId){
//        return new ResponseEntity<Indicadores>(IndicadoresService.getIndicadoresById(indicadoresId), HttpStatus.OK);
//    }
//
//
//    @GetMapping("/nomes/{nome}")
//    public ResponseEntity<List<Indicadores>> getIndicadoresByNome(@PathVariable("nome") String nome) {
//        return ResponseEntity.ok(IndicadoresService.getIndicadoresByNome(nome));
//    }
//
//    @PostMapping()
//    public ResponseEntity<Indicadores> saveIndicadores(@RequestBody Indicadores indicadores){
//        return new ResponseEntity<Indicadores>(indicadoresService.saveIndicadores(indicadores), HttpStatus.CREATED);
//
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<Indicadores> updateIndicadores(@PathVariable("id") long id
//            ,@RequestBody Indicadores Indicadores){
//        return new ResponseEntity<Indicadores>(IndicadoresService.updateIndicadores(Indicadores, id), HttpStatus.OK);
//    }
//
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteIndicadores(@PathVariable("id") long id){
//
//        IndicadoresService.deleteIndicadores(id);
//        return new ResponseEntity<String>("Indicadores Deletados!.", HttpStatus.OK);
//    }
//
//
//}
