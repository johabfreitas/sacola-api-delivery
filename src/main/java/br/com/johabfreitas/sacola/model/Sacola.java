package br.com.johabfreitas.sacola.model;

import br.com.johabfreitas.sacola.enumeration.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor //cria um constructor
@Builder //design patterns, criar objetos de forma simples
@Data //gera gets e sets, equals e hashcode.
@Entity //converte uma class em uma tabela no banco de dados.
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //ignorar erros que podem aparecer quando utiliza o hibernate em modo Lazy "preguiçoso"
@NoArgsConstructor //cria uma constructor vazio
public class Sacola {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itens;
    private Double valorTotal;
    @Enumerated
    private FormaPagamento FormaPagamento;
    private boolean fechada;


}
