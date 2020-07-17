package tads.eaj.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AlunoController {
    @Autowired
    AlunoService alunoService;

    @RequestMapping("/")
    public String getHome(Model model){
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
    public String addAluno(@ModelAttribute Aluno aluno){
        alunoService.add(aluno);
        return "redirect:/";
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
