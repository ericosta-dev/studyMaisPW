package tads.eaj.projeto.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.projeto.model.Aluno;
import tads.eaj.projeto.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    @Autowired
    public void setRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno insert(Aluno a){
        return alunoRepository.save(a);
    }

    public Aluno update(Aluno a){
        return alunoRepository.save(a);
    }

    public void delete(Long id){
        alunoRepository.deleteById(id);
    }

    public Aluno getOne(Long id){
        return alunoRepository.findById(id).orElse(null);
    }

    public Optional<Aluno> findById(Long id){
        return alunoRepository.findById(id);
    }

    public List<Aluno> getAll(){
        return alunoRepository.findAll();
    }

    public Aluno saveAndFlush(Aluno a){
        return alunoRepository.saveAndFlush(a);
    }
}
