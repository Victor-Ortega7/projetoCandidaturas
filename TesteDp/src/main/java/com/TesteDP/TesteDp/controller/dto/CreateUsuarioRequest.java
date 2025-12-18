package com.TesteDP.TesteDp.controller.dto;

import com.TesteDP.TesteDp.infrastructure.entitys.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUsuarioRequest {

    private String nome;
    private String email;
    private String password;
    private Role role;
}