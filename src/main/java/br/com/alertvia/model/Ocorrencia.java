package br.com.alertvia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    private String image;

    private String comentario;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
