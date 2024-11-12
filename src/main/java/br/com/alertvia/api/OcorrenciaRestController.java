package br.com.alertvia.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.alertvia.repository.OcorrenciaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/ocorrencia")
public class OcorrenciaRestController {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @GetMapping ("/ocorrencias-ano-corrente")
    public List<Object[]> servicosAnoCorrente(){
        return ocorrenciaRepository.imprimirServicosPorMes();
    }

    @GetMapping ("/ocorrencias-fechamento")
    public List<Object[]> servicosfechamento(){
        return ocorrenciaRepository.imprimirQuantidadeServicosAtendidosPorMes();
    }

}
