package br.com.johabfreitas.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
@Builder
@Data
@Entity
@JsonIgnoreProperties
@NoArgsConstructor
public class Restaurante {
    @Id//cria um id
    @GeneratedValue(strategy = GenerationType.AUTO) //gera um id automático, autoincremento
    private Long id;
    private String nome;
    @OneToMany(cascade = CascadeType.ALL) //relacionamento (1,n)
    private List<Produto> cardapio;
    @Embedded
    private Endereco endereco;
}
