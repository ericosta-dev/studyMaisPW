package tads.eaj.projeto.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor //Gera automaticamente construtor com todos os argumentos
@NoArgsConstructor  //Gera automaticamente construtor vazio
@Data               //Gera automaticamente getters e setters
@Entity             //Mapear essa classe para tornar uma table no banco
public class Aluno extends RepresentationModel<Aluno> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;
    String telefone;

}
