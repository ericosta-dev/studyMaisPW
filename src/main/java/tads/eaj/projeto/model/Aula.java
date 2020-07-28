package tads.eaj.projeto.model;

import javax.persistence.*;

@Entity
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String horario;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    Materia materia;
}
