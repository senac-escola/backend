package com.escola.backend.controller;

import com.escola.backend.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.escola.backend.service.UserService;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class
UserController {

    private final UserService UserService;

    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> findAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(UserService.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar usuários", e);
        }
    }

    @GetMapping("/users/{user_email}")
    public ResponseEntity<Users> findByEmail(@PathVariable String user_email) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(UserService.findByEmail(user_email));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar usuário", e);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody Users User) {
        try {
            Users existingUser = UserService.findByEmail(User.getUser_email());
            if (existingUser != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já cadastrado.");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(UserService.save(User));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao criar usuário", e);
        }
    }

    @PatchMapping("/users/{user_email}")
    public ResponseEntity<?> updateUser(@PathVariable String user_email, @RequestBody Users User) {
        try {
            Users updatedUser = UserService.findByEmail(user_email);
            Optional.ofNullable(User.getUser_email()).ifPresent(updatedUser::setUser_email);
            Optional.ofNullable(User.getUser_password()).ifPresent(updatedUser::setUser_password);
            Optional.ofNullable(User.getUser_name()).ifPresent(updatedUser::setUser_name);
            Optional.ofNullable(User.getUser_type()).ifPresent(updatedUser::setUser_type);
            Optional.ofNullable(User.getDocument_id()).ifPresent(updatedUser::setDocument_id);
            Optional.ofNullable(User.getUser_address()).ifPresent(updatedUser::setUser_address);
            Optional.ofNullable(User.getUser_phone()).ifPresent(updatedUser::setUser_phone);
            return ResponseEntity.status(HttpStatus.OK).body(UserService.save(updatedUser));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao atualizar usuário", e);
        }
    }

    @DeleteMapping("/users/{user_email}")
    public ResponseEntity<?> deleteByEmail(@PathVariable String user_email) {
        try {
            if (UserService.deleteByEmail(user_email) > 0) {
                return ResponseEntity.status(HttpStatus.OK).body("Usuário excluído com sucesso");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao excluir usuário", e);
        }
    }

}