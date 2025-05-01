package com.ndm.portfolio.ToDo.DTO.Login;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDTO (
        @NotBlank(message = "O campo do e-mail é obrigatório!")
        @Email(message = "Por favor, preencha o campo de e-mail corretamente!")
        String username,
        @NotBlank(message = "O campo password é obrigatório!!")
        @Size(min = 8,max = 20)
        String password
){

}
