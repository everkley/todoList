package org.evercley.mappers;

import org.evercley.dtos.UserDTO;
import org.evercley.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public User toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        return new User(dto.getId(),  dto.getUsername(), dto.getPassword());
    }

    public UserDTO toDto(User entity) {
        if (entity == null) {
            return null;
        }
        return new UserDTO(entity);
    }

    public List<UserDTO> toDtoList(List<User> listEntity) {
        return listEntity.stream().map(this::toDto).toList();
    }

}
