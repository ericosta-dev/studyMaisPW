package tads.eaj.projeto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@AllArgsConstructor //Gera automaticamente construtor com todos os argumentos
@NoArgsConstructor  //Gera automaticamente construtor vazio
@Data               //Gera automaticamente getters e setters
@Entity             //Mapear essa classe para tornar uma table no banco
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotBlank
    @Size(min=2, max=20, message = "Informe o valor entre 2-20 caracteres.")
    String nome;
    @NotBlank
    String escola;
    @NotNull
    Integer telefone;
}
