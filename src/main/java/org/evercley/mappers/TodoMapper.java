package org.evercley.mappers;

import org.evercley.dtos.TodoDTO;
import org.evercley.entities.Todo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoMapper {

    public Todo toEntity(TodoDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Todo(dto.getNome(), dto.getDescricao(), dto.getRealizado(), dto.getPrioridade());
    }

    public TodoDTO toDto(Todo todo) {
        if (todo == null) {
            return null;
        }
        return new TodoDTO(todo);
    }

    public List<TodoDTO> toDtoList(List<Todo> listTodo) {
        return listTodo.stream().map(this::toDto).toList();
    }
}
