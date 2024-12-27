package com.demo.spring.spring_boot_with_docker.atividade;

import com.demo.spring.spring_boot_with_docker.atividade.dto.AtividadeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/atividades")
public class AtividadeController {
    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public Iterable<AtividadeDTO> findAll() {
        List<Atividade> atividades = (List<Atividade>) atividadeService.findAll();

        return atividades.stream().map(AtividadeDTO::new).collect(Collectors.toList());
    }
}