package tads.eaj.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.projeto.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
