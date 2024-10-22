package br.com.alertvia.controller;

import br.com.alertvia.Repository.TipoOcorrenciaRepository;
import br.com.alertvia.model.Endereco;
import br.com.alertvia.model.Ocorrencia;
import br.com.alertvia.repository.OcorrenciaRepository;
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
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private TipoOcorrenciaRepository tipoOcorrenciaRepository;


    @GetMapping
    public String listar(Model model){
        model.addAttribute("ocorrencias",     ocorrenciaRepository.findAll());
        return "ocorrencias/listagem";
        //return "ocorrencias/ocorrencias";
    }

    @GetMapping("/form-inserir")
    public String formInserir(Model model){
        model.addAttribute("ocorrencia", new Ocorrencia());
        model.addAttribute("endereco", new Endereco());
        model.addAttribute("tipoocorrencias", tipoOcorrenciaRepository.findAll());

        return "ocorrencias/ocorrencias";

    }

    @GetMapping("/form-alterar/{id}")
    public String formAlterar(Model model, @PathVariable Long id){
        Ocorrencia ocorrencia = ocorrenciaRepository.findById(id).get();
        model.addAttribute("ocorrencia", ocorrencia);
        return "ocorrencias/form-alterar";
        //return "ocorrencias/ocorrencias";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        ocorrenciaRepository.deleteById(id);
        return "redirect:/ocorrencia";
    }

    @PostMapping("/salvar")
    public String salvar(
            @Valid Ocorrencia ocorrencia,
            BindingResult result,
            RedirectAttributes attributes,
            @RequestParam("foto") MultipartFile multipartFile
    ) throws IOException
    {

        if(result.hasErrors()){
            return "ocorrencia/form-inserir";
        }

        String extensao = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());

        attributes.addFlashAttribute("mensagem", "Ocorrencia salva com sucesso!");

        ocorrenciaRepository.save(ocorrencia);

        String fileName = ocorrencia.getId() + "." + extensao;
        ocorrencia.setImage(fileName);

        String uploadPasta =  "src/main/resources/static/assets/img/fotos-ocorrencias";

        ocorrenciaRepository.save(ocorrencia);

        FileUploadUtil.saveFile(uploadPasta, fileName, multipartFile);

        //return "redirect:/ocorrencia/form-inserir";
        return "redirect:/ocorrencia";
    }




}
