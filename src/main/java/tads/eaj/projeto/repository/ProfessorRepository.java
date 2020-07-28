package tads.eaj.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.projeto.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
