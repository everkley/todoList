package org.evercley.services;

import org.evercley.dtos.UserDTO;
import org.evercley.entities.User;
import org.evercley.excpetions.UserAlreadyExistsException;
import org.evercley.excpetions.UserNotFoundException;
import org.evercley.mappers.UserMapper;
import org.evercley.repositories.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.encoder = encoder;
    }

    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UserNotFoundException(username);
        }
        return userMapper.toDto(user);
    }

    public List<UserDTO> findAll() {
        Sort sort = Sort.by("id").ascending();
        List<UserDTO> usersDtoList = userMapper.toDtoList(userRepository.findAll(sort));
        return usersDtoList;
    }

    public UserDTO create(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new UserAlreadyExistsException("Username já está em uso.");
        }
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public Boolean validatePassword(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());
        return encoder.matches(userDTO.getPassword(), user.getPassword());
    }

    public UserDTO update(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());
        if (user == null) {
            throw new UserNotFoundException(userDTO.getUsername());
        }
        user.setUsername(userDTO.getUsername());
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            user.setPassword(encoder.encode(userDTO.getPassword()));
        }

        return userMapper.toDto(userRepository.save(user));
    }

    public void delete(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException(username);
        }
        userRepository.delete(user);
    }

}
