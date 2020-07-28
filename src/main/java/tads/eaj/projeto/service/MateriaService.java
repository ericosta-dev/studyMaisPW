package tads.eaj.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.projeto.model.Materia;
import tads.eaj.projeto.repository.MateriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    private MateriaRepository MateriaRepository;

    @Autowired
    public void setRepository(MateriaRepository MateriaRepository) {
        this.MateriaRepository = MateriaRepository;
    }

    public Materia insert(Materia m){
        return MateriaRepository.save(m);
    }

    public Materia update(Materia m){
        return MateriaRepository.save(m);
    }

    public void delete(Long id){
        MateriaRepository.deleteById(id);
    }

    public Materia getOne(Long id){
        return MateriaRepository.findById(id).orElse(null);
    }

    public Optional<Materia> findById(Long id){
        return MateriaRepository.findById(id);
    }

    public List<Materia> getAll(){
        return MateriaRepository.findAll();
    }

    public Materia saveAndFlush(Materia m){
        return MateriaRepository.saveAndFlush(m);
    }
}