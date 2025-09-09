package org.evercley.services;

import org.evercley.dtos.TodoDTO;
import org.evercley.entities.Todo;
import org.evercley.repositories.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoDTO create(TodoDTO dto) {
        Todo entity = new Todo(dto.getNome(), dto.getDescricao(), dto.getRealizado(), dto.getPrioridade());
        Todo saved = todoRepository.save(entity);
        return new TodoDTO(saved);
    }

    public List<TodoDTO> list() {
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
        return todoRepository.findAll(sort).stream().map(TodoDTO::new).toList();
    }


    public TodoDTO update(TodoDTO dto) {
        Todo entity = new Todo(dto.getNome(), dto.getDescricao(), dto.getRealizado(), dto.getPrioridade());
        Todo saved = todoRepository.save(entity);
        return new TodoDTO(saved);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

}
