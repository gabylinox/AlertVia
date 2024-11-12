package br.com.alertvia.repository;

import br.com.alertvia.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    // Executa Stored Procedure ImprimirServicosporMes() com query nativa
    @Query(value = "CALL ImprimirQuantidadeOcorrenciasporMes()", nativeQuery = true)
    List<Object[]> imprimirServicosPorMes();

    @Query(value = "CALL ImprimirQuantidadeServicosAtendidosPorMes()", nativeQuery = true)
    List<Object[]> imprimirQuantidadeServicosAtendidosPorMes();
}

