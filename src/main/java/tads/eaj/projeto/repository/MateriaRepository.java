package tads.eaj.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.projeto.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

}
