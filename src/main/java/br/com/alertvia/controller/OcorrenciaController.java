package br.com.alertvia.controller;

import br.com.alertvia.model.Ocorrencia;
import br.com.alertvia.repository.OcorrenciaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;


    @GetMapping
    public String listar(Model model){
        model.addAttribute("ocorrencias",     ocorrenciaRepository.findAll());
        //return "ocorrencia/listagem";
        return "ocorrencias/ocorrencias";
    }

    @GetMapping("/form-inserir")
    public String formInserir(Model model){
        model.addAttribute("ocorrencia", new Ocorrencia());
        return "ocorrencias/form-inserir";
    }

    @GetMapping("/form-alterar/{id}")
    public String formAlterar(Model model, @PathVariable Long id){
        Ocorrencia ocorrencia = ocorrenciaRepository.findById(id).get();
        model.addAttribute("ocorrencia", ocorrencia);
        return "ocorrencia/form-alterar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        ocorrenciaRepository.deleteById(id);
        return "redirect:/ocorrencia";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Ocorrencia ocorrencia, BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors()){
            return "ocorrencia/form-inserir";
        }

        attributes.addFlashAttribute("mensagem", "Ocorrencia salva com sucesso!");

        ocorrenciaRepository.save(ocorrencia);
        return "redirect:/ocorrencia";
    }




}
