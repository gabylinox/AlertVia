package br.com.alertvia.repository;

import br.com.alertvia.model.Cidadao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadaoRepository extends JpaRepository<Cidadao, Long> {
}
