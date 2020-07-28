package tads.eaj.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2
public class ProjetoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoApplication.class, args);
    }

//    @Bean
//    public Docket productApi(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("tads.eaj.projeto.controller"))
//                .paths((PathSelectors.any()))
//                .build()
//                .apiInfo(new ApiInfoBuilder().version("1.0").title("API studyMais").description("API para o meu projeto").build());
//    }
}
