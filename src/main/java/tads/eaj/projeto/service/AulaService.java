package tads.eaj.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.projeto.model.Aula;
import tads.eaj.projeto.repository.AulaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {
    private AulaRepository repository;

    @Autowired
    public void setRepository(AulaRepository repository){
        this.repository = repository;
    }

    public Aula insert(Aula a){
        return repository.save(a);
    }

    public Aula update(Aula a){
        return repository.save(a);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Aula getOne(Long id){
        return repository.findById(id).orElse(null);
    }

    public Optional<Aula> findById(Long id){
        return repository.findById(id);
    }

    public List<Aula> getAll(){
        return repository.findAll();
    }

    public Aula saveAndFlush(Aula a){
        return repository.saveAndFlush(a);
    }
}
