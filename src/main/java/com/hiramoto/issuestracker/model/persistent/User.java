package com.hiramoto.issuestracker.model.persistent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Login deve ser preenchido.")
    private String login;

    @NotBlank(message = "O E-mail deve ser preenchido.")
    private String email;

    @NotBlank(message = "A senha deve ser preenchida.")
    private String password;
    
}
