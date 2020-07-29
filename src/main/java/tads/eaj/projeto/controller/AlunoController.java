package tads.eaj.projeto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.projeto.model.Aluno;
import tads.eaj.projeto.service.AlunoService;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = {"http://localhost:3000"}, exposedHeaders = "X-Total-Count")
public class AlunoController {
    private AlunoService service;

    public void setService(AlunoService service){
        this.service = service;
    }

    @GetMapping
    public List<Aluno> listAll(){
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Aluno> getOne(@PathVariable Long id){

        return service
                .findById(id)
                .map(
                        record -> ResponseEntity.ok().body(record)
                ).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aluno insert(@RequestBody Aluno a){
        return service.insert(a);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno a){
        return service
                .findById(id)
                .map( record -> {
                    service.saveAndFlush(a);
                    return ResponseEntity.ok().body(a);

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
