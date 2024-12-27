package com.demo.spring.spring_boot_with_docker.atividade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public Atividade save(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public Iterable<Atividade> findAll() {
        return atividadeRepository.findAll();
    }

    public Atividade findById(Long id) {
        return atividadeRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        atividadeRepository.deleteById(id);
    }

    public Atividade update(Long id, Atividade atividade) {
        if (atividadeRepository.existsById(id)) {
            return atividadeRepository.save(atividade);
        }
        return null;
    }
}
