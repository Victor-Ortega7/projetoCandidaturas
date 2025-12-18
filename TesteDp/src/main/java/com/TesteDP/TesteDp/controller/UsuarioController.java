package com.TesteDP.TesteDp.controller;

import com.TesteDP.TesteDp.business.UsuarioService;
import com.TesteDP.TesteDp.infrastructure.entitys.Usuario;
import com.TesteDP.TesteDp.controller.dto.CreateUsuarioRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.TesteDP.TesteDp.controller.dto.LoginRequest;
import com.TesteDP.TesteDp.controller.dto.LoginResponse;
import com.TesteDP.TesteDp.infrastructure.security.JwtService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<Void>register(
            @RequestBody CreateUsuarioRequest request){
         Usuario usuario = Usuario.builder()
                 .nome(request.getNome())
                 .email(request.getEmail())
                 .password(request.getPassword())
                 .role(request.getRole())
                 .build();

         usuarioService.salvarUsusario(usuario);

         return ResponseEntity.status(HttpStatus.CREATED).build();
    }



    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.deleteUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuario(@RequestParam Integer Id,
                                                @RequestBody Usuario usuario){
        usuarioService.atualizarUsuarioPorId(Id, usuario);
        return ResponseEntity.ok().build();

    }


}
