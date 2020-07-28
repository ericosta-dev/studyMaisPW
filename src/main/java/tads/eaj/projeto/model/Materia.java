package tads.eaj.projeto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @JsonBackReference
    Professor professor;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "materia_aluno",
            joinColumns = @JoinColumn(name = "materia_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    List<Aluno> alunos;
}
