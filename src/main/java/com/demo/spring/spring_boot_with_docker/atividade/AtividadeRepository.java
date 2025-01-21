package com.demo.spring.spring_boot_with_docker.atividade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
}
