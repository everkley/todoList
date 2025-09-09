package org.evercley.dtos;

import org.evercley.entities.Todo;

public class TodoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Boolean realizado;
    private Integer prioridade;

    public TodoDTO() {
    }

    public TodoDTO(Todo todo){
        id = todo.getId();
        nome = todo.getNome();
        descricao = todo.getDescricao();
        realizado = todo.getRealizado();
        prioridade = todo.getPrioridade();
    }

    public TodoDTO(Long id, String nome, String descricao, Boolean realizado, Integer prioridade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }
}
