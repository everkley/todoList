package org.evercley.services;

import org.evercley.dtos.TodoDTO;
import org.evercley.entities.Todo;
import org.evercley.mappers.TodoMapper;
import org.evercley.repositories.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public TodoService(TodoRepository todoRepository, TodoMapper todoMapper) {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
    }

    public TodoDTO create(TodoDTO dto) {
        Todo entity = todoMapper.toEntity(dto);
        Todo saved = todoRepository.save(entity);
        return todoMapper.toDto(saved);
    }

    public List<TodoDTO> list() {
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
        return todoMapper.toDtoList(todoRepository.findAll(sort));
    }


    public TodoDTO update(TodoDTO dto) {
        Todo entity = todoMapper.toEntity(dto);
        Todo saved = todoRepository.save(entity);
        return todoMapper.toDto(saved);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

}
