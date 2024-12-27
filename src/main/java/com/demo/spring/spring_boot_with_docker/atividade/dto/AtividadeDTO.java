package com.demo.spring.spring_boot_with_docker.atividade.dto;

import com.demo.spring.spring_boot_with_docker.atividade.Atividade;
import com.demo.spring.spring_boot_with_docker.atividade.StatusAtividade;

public class AtividadeDTO {
    public Long id;
    public String nome;
    public String descricao;
    public StatusAtividade status;

    public AtividadeDTO(Atividade atividade) {
        this.id = atividade.getId();
        this.nome = atividade.getDescricao();
        this.descricao = atividade.getDescricao();
        this.status = atividade.getStatus();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusAtividade getStatus() {
        return status;
    }

    public void setStatus(StatusAtividade status) {
        this.status = status;
    }
}