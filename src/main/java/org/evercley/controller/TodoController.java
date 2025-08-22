package org.evercley.controller;


import io.swagger.v3.oas.annotations.Operation;
import org.evercley.entities.Todo;
import org.evercley.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {


    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cria uma TODO")
    List<Todo> crate(@RequestBody Todo todo){
        return todoService.create(todo);
    }

    @GetMapping("/listar")
    @Operation(summary = "Retorna uma lista de TODOs")
    List<Todo> list(){
        return todoService.list();
    }

    @PutMapping("/atualizar")
    @Operation (summary = "Atualiza uma TODO")
    List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    @DeleteMapping("/deletar{id}")
    @Operation(summary = "Deleta uma todo com base no ID")
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }
}
