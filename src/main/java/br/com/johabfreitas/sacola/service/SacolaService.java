package br.com.johabfreitas.sacola.service;

import br.com.johabfreitas.sacola.model.Item;
import br.com.johabfreitas.sacola.model.Sacola;
import br.com.johabfreitas.sacola.resource.dto.ItemDto;

public interface SacolaService {
    Item incluirItemNaSacola(ItemDto itemDto);
    Sacola verSacola(Long id);
    Sacola fecharSacola(Long id, int formaPagamento);
}
