package org.evercley.controllers;


import io.swagger.v3.oas.annotations.Operation;
import org.evercley.dtos.TodoDTO;
import org.evercley.entities.Todo;
import org.evercley.services.TodoService;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<TodoDTO> crate(@RequestBody TodoDTO todoDto) {
        todoService.create(todoDto);
        return ResponseEntity.ok().body(todoDto);
    }

    @GetMapping("/listar")
    @Operation(summary = "Retorna uma lista de TODOs")
    ResponseEntity<List<TodoDTO>> list() {
        List<TodoDTO> TodoDtos = todoService.list();
        return ResponseEntity.ok().body(TodoDtos);
    }

    @PutMapping("/atualizar")
    @Operation(summary = "Atualiza uma TODO")
    ResponseEntity<TodoDTO> update(@RequestBody TodoDTO todoDto) {
        todoService.update(todoDto);
        return ResponseEntity.ok().body(todoDto);
    }

    @DeleteMapping("/deletar{id}")
    @Operation(summary = "Deleta uma todo com base no ID")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
