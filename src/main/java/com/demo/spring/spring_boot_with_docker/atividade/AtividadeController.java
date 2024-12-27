package com.demo.spring.spring_boot_with_docker.atividade;

import com.demo.spring.spring_boot_with_docker.atividade.dto.AtividadeDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/atividades")
public class AtividadeController {
    @Autowired
    private AtividadeService atividadeService;

    @Operation(summary = "Listar todas as atividades")
    @GetMapping
    public Iterable<AtividadeDTO> findAll() {
        List<Atividade> atividades = (List<Atividade>) atividadeService.findAll();

        return atividades.stream().map(AtividadeDTO::new).collect(Collectors.toList());
    }

    @Operation(summary = "Busca uma atividade a partir de seu id")
    @GetMapping(value = "/{id}")
    public AtividadeDTO findById(@PathVariable Long id) {
        return new AtividadeDTO(atividadeService.findById(id));
    }

    @Operation(summary = "Cria uma nova atividade")
    @PostMapping()
    public AtividadeDTO save(@RequestBody Atividade atividade) {
        return new AtividadeDTO(atividadeService.save(atividade));
    }

    @Operation(summary = "Deleta uma atividade cadastrada a partir de seu id")
    @DeleteMapping(value = "/{id}")
    public void delete(Long id) {
        atividadeService.delete(id);
    }

    @Operation(summary = "Atualiza uma atividade cadastrada a partir de seu id")
    @PutMapping(value = "/{id}")
    public AtividadeDTO update(@PathVariable Long id, @RequestBody Atividade atividade) {
        return new AtividadeDTO(atividadeService.update(id, atividade));
    }
}