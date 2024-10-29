package br.com.alertvia.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.alertvia.Repository.OcorrenciaRepository;

import java.util.List;

@RestController
public class OcorrenciaRestController {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @GetMapping ("/ocorrencias-ano-corrente")
    public List<Object[]> servicosAnoCorrente(){
        return ocorrenciaRepository.imprimirServicosPorMes();
    }

}
