package com.escola.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Users implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    @NotBlank(message = "E-mail é obrigatório")
    private String user_email;

    @NotBlank(message = "Senha é obrigatória")
    private String user_password;

    @Column(unique = true)
    @NotBlank(message = "Nome de usuário é obrigatório")
    private String user_name;

    @NotBlank(message = "Tipo de usuário é obrigatório")
    private String user_type;

    @Column(unique = true)
    @NotBlank(message = "Documento é obrigatório")
    private String document_id;

    @NotBlank(message = "Endereço é obrigatório")
    private String user_address;

    @Column(unique = true)
    @NotNull(message = "Número de telefone é obrigatório")
    private Long user_phone;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return user_password;
    }

    @Override
    public String getUsername() {
        return user_email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
