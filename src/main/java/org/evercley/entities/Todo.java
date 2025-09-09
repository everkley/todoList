package org.evercley.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Boolean realizado;
    private Integer prioridade;


    public Todo() {
    }

    public Todo(Long id, String nome, String descricao, Boolean realizado, Integer prioridade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return prioridade == todo.prioridade && Objects.equals(id, todo.id) && Objects.equals(nome, todo.nome) && Objects.equals(descricao, todo.descricao) && Objects.equals(realizado, todo.realizado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, realizado, prioridade);
    }
}
