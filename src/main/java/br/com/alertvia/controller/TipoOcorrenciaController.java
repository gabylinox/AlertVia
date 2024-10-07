package br.com.alertvia.controller;

import br.com.alertvia.Repository.TipoOcorrenciaRepository;
import br.com.alertvia.model.Endereco;
import br.com.alertvia.model.Ocorrencia;
import br.com.alertvia.model.TipoOcorrencia;
import br.com.alertvia.util.FileUploadUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/tipoocorrencia")
public class TipoOcorrenciaController {
    @Autowired
    private TipoOcorrenciaRepository tipoOcorrenciaRepository;


    @GetMapping
    public String listar(Model model){
        model.addAttribute("tipoocorrencias",tipoOcorrenciaRepository.findAll());
        return "tipoocorrencia/listagem";
    }

    @GetMapping("/form-inserir")
    public String formInserir(Model model){
        model.addAttribute("tipoocorrencia", new TipoOcorrencia());
        return "tipoocorrencia/form-inserir";
    }

    @GetMapping("/form-alterar/{id}")
    public String formAlterar(Model model, @PathVariable Long id){
        TipoOcorrencia tipoOcorrencia = tipoOcorrenciaRepository.findById(id).get();
        model.addAttribute("tipoocorrencia", tipoOcorrencia);
        return "tipoocorrencia/form-alterar";
        //return "ocorrencias/ocorrencias";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        tipoOcorrenciaRepository.deleteById(id);
        return "redirect:/tipoocorrencia";
    }

    @PostMapping("/salvar")
    public String salvar(
            @Valid TipoOcorrencia tipoOcorrencia,
            BindingResult result,
            RedirectAttributes attributes
    )
    {

        if(result.hasErrors()){
            return "tipoocorrencia/form-inserir";
        }

        attributes.addFlashAttribute("mensagem", "Ocorrencia salva com sucesso!");

        tipoOcorrenciaRepository.save(tipoOcorrencia);

        //return "redirect:/ocorrencia/form-inserir";
        return "redirect:/tipoocorrencia";
    }




}
