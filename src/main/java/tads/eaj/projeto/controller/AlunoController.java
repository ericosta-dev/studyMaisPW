package tads.eaj.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tads.eaj.projeto.model.Aluno;
import tads.eaj.projeto.service.AlunoService;

import java.util.List;

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


}
