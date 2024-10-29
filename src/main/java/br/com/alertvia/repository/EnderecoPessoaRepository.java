package br.com.alertvia.repository;

import br.com.alertvia.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoPessoaRepository extends JpaRepository <Endereco, Long> {
}
