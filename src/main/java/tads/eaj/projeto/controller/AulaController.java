package tads.eaj.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tads.eaj.projeto.model.Aula;
import tads.eaj.projeto.service.AulaService;

import java.util.List;

@Service
@RequestMapping("/aula")
public class AulaController {

    private AulaService service;

    @Autowired
    public void setService(AulaService service){
        this.service = service;
    }

    @GetMapping
    public List<Aula> listAll(){
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Aula> getOne(@PathVariable Long id){
        return service
        .findById(id)
        .map(
                record -> ResponseEntity.ok().body(record)
        ).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aula insert(@RequestBody Aula a){
        return service.insert(a);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Aula> update(@PathVariable Long id, @RequestBody Aula a){
        return service
                .findById(id)
                .map(   record ->{
                            service.saveAndFlush(a);
                            return ResponseEntity.ok().body(a);
                            }
                ).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service
                .findById(id)
                .map( record -> {
                    service.delete(id);
                    return ResponseEntity.ok().build();

                }).orElse(ResponseEntity.notFound().build());
    }
}
