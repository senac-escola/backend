package com.escola.backend.controller;

import com.escola.backend.model.Users;
import com.escola.backend.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users users) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(users.getUser_email(), users.getUser_password());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        Users principal = (Users) authenticate.getPrincipal();
        return ResponseEntity.ok(tokenService.gerarToken(principal));
    }

    @GetMapping("/teste")
    public String teste() {
        return "Teste";
    }

}
