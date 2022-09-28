package br.com.johabfreitas.sacola.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor
@Builder
@Data
@Embeddable //reuso de código
@NoArgsConstructor
public class Endereco {
    private String cep;
    private String complemento;
}
