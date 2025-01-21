package com.demo.spring.spring_boot_with_docker.atividade;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Transactional
    public Atividade save(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    @Transactional
    public Iterable<Atividade> findAll() {
        return atividadeRepository.findAll();
    }

    @Transactional
    public Atividade findById(Long id) {
        return atividadeRepository.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Long id) {
        atividadeRepository.deleteById(id);
    }

    @Transactional
    public Atividade update(Long id, Atividade atividade) {
        if (atividadeRepository.existsById(id)) {
            atividade.setId(id);
            return atividadeRepository.save(atividade);
        }
        return null;
    }
}
