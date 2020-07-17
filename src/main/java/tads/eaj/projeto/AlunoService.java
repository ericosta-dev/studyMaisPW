package tads.eaj.projeto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }


    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }

    public void add(Aluno aluno){
        alunoRepository.save(aluno);
    }

    public Aluno get(Long id){
        return alunoRepository.getOne(id);
    }

    public void delete(Long id){
        alunoRepository.deleteById(id);
    }
}
