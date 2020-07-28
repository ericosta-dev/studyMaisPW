package tads.eaj.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.projeto.model.Professor;
import tads.eaj.projeto.repository.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private ProfessorRepository ProfessorRepository;

    @Autowired
    public void setRepository(ProfessorRepository ProfessorRepository) {
        this.ProfessorRepository = ProfessorRepository;
    }

    public Professor insert(Professor p){
        return ProfessorRepository.save(p);
    }

    public Professor update(Professor p){
        return ProfessorRepository.save(p);
    }

    public void delete(Long id){
        ProfessorRepository.deleteById(id);
    }

    public Professor getOne(Long id){
        return ProfessorRepository.findById(id).orElse(null);
    }

    public Optional<Professor> findById(Long id){
        return ProfessorRepository.findById(id);
    }

    public List<Professor> getAll(){
        return ProfessorRepository.findAll();
    }

    public Professor saveAndFlush(Professor p){
        return ProfessorRepository.saveAndFlush(p);
    }
}
