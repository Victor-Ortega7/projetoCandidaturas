package com.TesteDP.TesteDp.business;

import com.TesteDP.TesteDp.infrastructure.entitys.Usuario;
import com.TesteDP.TesteDp.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;


    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsusario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }

    public buscarUsuarioPorId(){

    }

}
