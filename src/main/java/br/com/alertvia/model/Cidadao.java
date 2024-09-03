package br.com.alertvia.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "D")
public class Cidadao extends Pessoa{
}