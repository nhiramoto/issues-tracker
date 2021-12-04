package com.hiramoto.issuestracker.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "O Login deve ser preenchido.")
    private String login;

    @NotBlank(message = "O E-mail deve ser preenchido.")
    private String email;

    @NotBlank(message = "A senha deve ser preenchida.")
    private String password;
    
}
