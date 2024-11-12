package br.com.alertvia.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)



public class Ocorrencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    private String comentario;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dataFechamento;

    private String dsFechamento;



    @ManyToOne
    private TipoOcorrencia tipoOcorrencia;

    private String image;






    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

