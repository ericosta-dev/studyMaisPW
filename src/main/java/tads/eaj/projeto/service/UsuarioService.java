package tads.eaj.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.projeto.model.Usuario;
import tads.eaj.projeto.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository alunoRepository;

    @Autowired
    public void setRepository(UsuarioRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Usuario insert(Usuario u){
        return alunoRepository.save(u);
    }

    public Usuario update(Usuario u){
        return alunoRepository.save(u);
    }

    public void delete(Long id){
        alunoRepository.deleteById(id);
    }

    public Usuario getOne(Long id){
        return alunoRepository.findById(id).orElse(null);
    }

    public Optional<Usuario> findById(Long id){
        return alunoRepository.findById(id);
    }

    public List<Usuario> getAll(){
        return alunoRepository.findAll();
    }

    public Usuario saveAndFlush(Usuario u){
        return alunoRepository.saveAndFlush(u);
    }
}