package com.example.sub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaisDTO {

    @JsonProperty("Código")
    private String codigo;
    @JsonProperty("Descrição")
    private String descricao;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
