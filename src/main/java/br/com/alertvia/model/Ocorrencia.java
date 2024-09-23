package br.com.alertvia.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)


public class Ocorrencia {
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    private String image;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
