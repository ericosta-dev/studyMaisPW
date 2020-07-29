package tads.eaj.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.projeto.model.Professor;
import tads.eaj.projeto.service.ProfessorService;

import java.util.List;

@RestController
@RequestMapping("/professor")@CrossOrigin(origins = {"http://localhost:3000"}, exposedHeaders = "X-Total-Count")
public class ProfessorController {
    private ProfessorService service;

    @Autowired
    public void setService(ProfessorService service){
        this.service = service;
    }

    @GetMapping
    public List<Professor> listAll(){
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Professor> getOne(@PathVariable Long id){

        return service
                .findById(id)
                .map(
                        record -> ResponseEntity.ok().body(record)
                ).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Professor insert(@RequestBody Professor p){
        return service.insert(p);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Professor> update(@PathVariable Long id, @RequestBody Professor p){
        return service
                .findById(id)
                .map( record -> {
                    service.saveAndFlush(p);
                    return ResponseEntity.ok().body(p);

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