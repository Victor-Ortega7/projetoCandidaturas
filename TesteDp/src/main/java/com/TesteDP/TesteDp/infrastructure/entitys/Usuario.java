package com.TesteDP.TesteDp.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Table (name = "usuario")
@Entity

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (nullable = false, name = "email", unique = true)
    private String email;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false)
    private String password;

    @Column()
    private Role role; // ADMIN ou USER

    public Usuario() {
    }

    public Usuario(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
