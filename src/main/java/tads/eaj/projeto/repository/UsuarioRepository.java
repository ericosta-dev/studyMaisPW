package tads.eaj.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.projeto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
