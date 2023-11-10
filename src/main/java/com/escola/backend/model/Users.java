package com.escola.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Users {

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

}
