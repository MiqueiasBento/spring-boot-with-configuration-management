package com.demo.spring.spring_boot_with_docker.atividade.dto;

import com.demo.spring.spring_boot_with_docker.atividade.Atividade;
import com.demo.spring.spring_boot_with_docker.atividade.StatusAtividade;

public class AtividadeDTO {
    public Long id;
    public String descricao;
    public StatusAtividade status;
    public String responsavel;

    public AtividadeDTO(Atividade atividade) {
        this.id = atividade.getId();
        this.responsavel = atividade.getResponsavel();
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

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public StatusAtividade getStatus() {
        return status;
    }

    public void setStatus(StatusAtividade status) {
        this.status = status;
    }
}