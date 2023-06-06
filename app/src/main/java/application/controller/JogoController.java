package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Jogo;
import application.model.JogoRepository;

@Controller
public class JogoController {

    @Autowired
    private JogoRepository jogoRepo;


    @RequestMapping("/jogo")
    public String list(Model model) {
        model.addAttribute("jogos", jogoRepo.findAll());
        return "WEB-INF/list.jsp";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "WEB-INF/insert.jsp";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("titulo") String titulo,@RequestParam("ano") int ano) {
        Jogo jogo = new Jogo();
        jogo.setTitulo(titulo);
        jogo.setAno(ano);

        jogoRepo.save(jogo);

        return "redirect:/jogo";
    }

    @RequestMapping("/update")
    public String update(Model model, @RequestParam("id") int id) {
        Optional<Jogo> jogo = jogoRepo.findById(id);

        if(!jogo.isPresent()) {
            return "redirect:/jogo";
        }

        model.addAttribute("jogo", jogo.get());
        return "WEB-INF/update.jsp";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("titulo") String titulo,
        @RequestParam("ano") int ano,
        @RequestParam("id") int id
    
    ) {
        Optional<Jogo> jogo = jogoRepo.findById(id);
        if(!jogo.isPresent()) {
            return "redirect:/jogo";
        }

        jogo.get().setTitulo(titulo);
        jogo.get().setAno(ano);

        jogoRepo.save(jogo.get());
        return "redirect:/jogo";
    }

    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam("id") int id) {
        Optional<Jogo> jogo = jogoRepo.findById(id);

        if(!jogo.isPresent()) {
            return "redirect:/jogo";
        }

        model.addAttribute("jogo", jogo.get());
        return "WEB-INF/delete.jsp";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") int id) {
        jogoRepo.deleteById(id);
        return "redirect:/jogo";
    }
}
