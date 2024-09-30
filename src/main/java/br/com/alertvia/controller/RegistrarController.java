package br.com.alertvia.controller;

import br.com.alertvia.model.Cidadao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publico")
public class RegistrarController {

    @GetMapping("/registrar-se")
    public String resgistarSe(Model model){
        model.addAttribute("cidadao", new Cidadao());
        return "cidadao/form-inserir";
    }

}
