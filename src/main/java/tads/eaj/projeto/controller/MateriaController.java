package tads.eaj.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.projeto.model.Materia;
import tads.eaj.projeto.service.MateriaService;

import java.util.List;

@RestController
@RequestMapping("/materia")
@CrossOrigin(origins = {"http://localhost:3000"}, exposedHeaders = "X-Total-Count")
public class MateriaController {
    private MateriaService service;

    @Autowired
    public void setService(MateriaService service){
        this.service = service;
    }

    @GetMapping
    public List<Materia> listAll(){
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Materia> getOne(@PathVariable Long id){

        return service
                .findById(id)
                .map(
                        record -> ResponseEntity.ok().body(record)
                ).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Materia insert(@RequestBody Materia m){
        return service.insert(m);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Materia> update(@PathVariable Long id, @RequestBody Materia m){
        return service
                .findById(id)
                .map( record -> {
                    service.saveAndFlush(m);
                    return ResponseEntity.ok().body(m);

                }).orElse(ResponseEntity.notFound().build());
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