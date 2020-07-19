package tads.eaj.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AlunoController {
    @Autowired
    AlunoService alunoService;

    @RequestMapping("/")
    public String getHome(Model model, HttpServletResponse response) {
        SimpleDateFormat formatado = new SimpleDateFormat("dd-MM-YYYY'_'HH:MM");
        Date data = new Date();
        String ultimoAcesso = "Ultimo_acesso" + formatado.format(data).toString();
        Cookie c = new Cookie("acesso", ultimoAcesso);

        response.addCookie(c);


        List<Aluno> alunoList = alunoService.findAll();
        model.addAttribute("alunoList", alunoList);

        return "index";
    }

    @RequestMapping("/cadastrar")
    public String getPageCadastro(Model model){
        var aluno = new Aluno();
        model.addAttribute("aluno", aluno);
        return "cadastrar";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String addAluno(@ModelAttribute @Valid Aluno aluno, Errors errors){
        if (errors.hasErrors()){
            return "cadastrar";
        } else {
            alunoService.add(aluno);
            return "redirect:/";
        }

    }

    @RequestMapping("/editar/{id}")
    public ModelAndView editAluno(@PathVariable(name = "id") Long id){
        var modelAndView = new ModelAndView("editar");
        var aluno = alunoService.get(id);
        modelAndView.addObject("aluno", aluno);
        return modelAndView;
    }

    @RequestMapping("/deletar/{id}")
    public String deleteAluno(@PathVariable(name = "id")Long id){
        alunoService.delete(id);
        return "redirect:/";
    }

}
