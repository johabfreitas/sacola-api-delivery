package br.com.johabfreitas.sacola.service.impl;

import br.com.johabfreitas.sacola.enumeration.FormaPagamento;
import br.com.johabfreitas.sacola.model.Item;
import br.com.johabfreitas.sacola.model.Sacola;
import br.com.johabfreitas.sacola.repository.ProdutoRepository;
import br.com.johabfreitas.sacola.repository.SacolaRepository;
import br.com.johabfreitas.sacola.resource.dto.ItemDto;
import br.com.johabfreitas.sacola.service.SacolaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SacolaServiceImpl implements SacolaService {
    private final SacolaRepository sacolaRepository;
    private final ProdutoRepository produtoRepository;
    @Override
    public Item incluirItemNaSacola(ItemDto itemDto) {
        Sacola sacola = verSacola(itemDto.getSacolaId());

       if(sacola.isFechada()){
           throw new RuntimeException("Esta sacola está fechada");
       }

       Item itemParaSerInserido = Item.builder()
               .quantidade(itemDto.getQuantidade())
               .sacola(sacola)
               .produto(produtoRepository.findById(itemDto.getProdutoId()).orElseThrow(
                       () -> {
                           throw new RuntimeException("Essa sacola não existe");
                       }
                ))
               .build();

        return null;
    }

    @Override
    public Sacola verSacola(Long id) {
        return sacolaRepository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("Essa sacola não existe");
                }
        ); //orElseThrow functional interface
    }

    @Override
    public Sacola fecharSacola(Long id, int numeroformaPagamento) {
        Sacola sacola = verSacola(id);

        if (sacola.getItens().isEmpty()){
            throw new RuntimeException("Inclua itens na sacola!");
        }

        FormaPagamento formaPagamento =
                numeroformaPagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;

        sacola.setFormaPagamento(formaPagamento);
        sacola.setFechada(true);
        return sacolaRepository.save(sacola);
    }
}
