package br.com.alertvia.controller;

import br.com.alertvia.Repository.CidadaoRepository;
import br.com.alertvia.model.Cidadao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cidadao")
public class CidadaoController {
    @Autowired
    private CidadaoRepository cidadaoRepository;


    @GetMapping
    public String listar(Model model){
        model.addAttribute("cidadoes",     cidadaoRepository.findAll());
        return "cidadao/listagem";
    }

    @GetMapping("/form-inserir")
    public String formInserir(Model model){
        model.addAttribute("cidadao", new Cidadao());
        return "cidadao/form-inserir";
    }

    @GetMapping("/form-alterar/{id}")
    public String formAlterar(Model model, @PathVariable Long id){
        Cidadao cidadao = cidadaoRepository.findById(id).get();
        model.addAttribute("cidadao", cidadao);
        return "cidadao/form-alterar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        cidadaoRepository.deleteById(id);
        return "redirect:/cidadao";
    }

    @PostMapping("/salvar")
    public String salvar(Cidadao cidadao){
        cidadaoRepository.save(cidadao);
        return "redirect:/cidadao";
    }

    


}
