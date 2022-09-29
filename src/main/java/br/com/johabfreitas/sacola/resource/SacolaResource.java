package br.com.johabfreitas.sacola.resource;

import br.com.johabfreitas.sacola.model.Item;
import br.com.johabfreitas.sacola.model.Sacola;
import br.com.johabfreitas.sacola.resource.dto.ItemDto;
import br.com.johabfreitas.sacola.service.SacolaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController // Com essa anotação informo para o Spring que esta classe vai conter os endpoint;
@RequestMapping("/ifood-devweek/sacolas")
@RequiredArgsConstructor
public class SacolaResource {

    private final SacolaService sacolaService;

    @PostMapping
    public Item incluirItemNaSacola(@RequestBody ItemDto itemDto) {
        return sacolaService.incluirItemNaSacola(itemDto);
    }

    @GetMapping("/{id}")
    public Sacola verSacola(@PathVariable("id") Long id){
        return sacolaService.verSacola(id);
    }

    @PatchMapping("/fecharSacola/{sacolaId}")
    public Sacola fecharSacola(@PathVariable("sacolaId") Long sacolaId,
                               @RequestParam("formaPagamento") int formaPagamento){
        return sacolaService.fecharSacola(sacolaId, formaPagamento);
    }

}
