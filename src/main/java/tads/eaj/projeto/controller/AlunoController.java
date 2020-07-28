package tads.eaj.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.projeto.model.Aluno;
import tads.eaj.projeto.service.AlunoService;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private AlunoService service;

    @Autowired
    public void setService(AlunoService service){
        this.service = service;
    }

    @GetMapping
    public List<Aluno> listAll(){
        return service.getAll();
    }

    @PostMapping
    public Aluno insert(@RequestBody Aluno a){
        return service.insert(a);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Aluno> getOne(@PathVariable Long id){

        Optional<Aluno> alunoOptional = service.findById(id);

        if (alunoOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Aluno aluno = alunoOptional.get();
            aluno.add(linkTo(AlunoController.class).slash(id).withSelfRel());
            aluno.add(linkTo(AlunoController.class).withRel("all-alunos"));

            return ResponseEntity.ok().body(aluno);


        }
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
