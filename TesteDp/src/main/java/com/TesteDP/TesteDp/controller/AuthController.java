package com.TesteDP.TesteDp.controller;

import com.TesteDP.TesteDp.business.UsuarioService;
import com.TesteDP.TesteDp.controller.dto.LoginRequest;
import com.TesteDP.TesteDp.controller.dto.LoginResponse;
import com.TesteDP.TesteDp.infrastructure.entitys.Usuario;
import com.TesteDP.TesteDp.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        Usuario usuario = usuarioService.buscarUsuarioPorEmail(request.getEmail());

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = jwtService.gerarToken(
                usuario.getEmail(),
                usuario.getRole().name()
        );

        return ResponseEntity.ok(new LoginResponse(token));
    }
}