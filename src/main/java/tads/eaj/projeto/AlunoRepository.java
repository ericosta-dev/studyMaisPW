package tads.eaj.projeto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {

    List<Aluno> findByNome(String nome);
    //List<Aluno> findByEscola(String escola);

}
