package tads.eaj.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.projeto.model.Aula;
import tads.eaj.projeto.repository.AulaRepository;

@Service
public class AulaController {

    private AulaRepository aulaRepository;

    @Autowired
    public void setRepository(AulaRepository aulaRepository){
        this.aulaRepository = aulaRepository;
    }

    public Aula insert(Aula a){
        return aulaRepository.save(a);
    }

}
