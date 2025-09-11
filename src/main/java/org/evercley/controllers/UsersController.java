package org.evercley.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.evercley.dtos.UserDTO;
import org.evercley.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{username}")
    @Operation(summary = "retorna o usuário ")
    public ResponseEntity<UserDTO> listarPorUsername(@PathVariable("username") String username) {
        UserDTO userDTO = userService.findByUsername(username);
        return ResponseEntity.ok().body(userDTO);
    }

    @GetMapping("listar")
    @Operation(summary = "retorna a lista de usuários")
    public ResponseEntity<List<UserDTO>> listarTodos() {
        List<UserDTO> userDTOList = userService.findAll();
        return ResponseEntity.ok().body(userDTOList);
    }

    @PostMapping("cadastrar")
    @Operation(summary = "cadastra um usuário")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {
        UserDTO userDTO = userService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }

    @PostMapping("validarUsuario")
    @Operation(summary = "valida se a senha informada pertence ao usuário")
    public ResponseEntity<Boolean> validarPassword(@RequestBody UserDTO dto) {
        return ResponseEntity.ok().body(userService.validatePassword(dto));
    }
}
