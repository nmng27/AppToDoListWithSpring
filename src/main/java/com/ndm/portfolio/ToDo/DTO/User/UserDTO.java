package com.ndm.portfolio.ToDo.DTO.User;

import com.ndm.portfolio.ToDo.Enum.Job.Job;
import com.ndm.portfolio.ToDo.Enum.Role.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class UserDTO {
    @NotBlank(message = "O campo nome é obrigatório!!!")
    public String name;
    @NotBlank(message = "O campo email é obrigatório!!!")
    public String email;
    @NotBlank(message = "O campo date é obrigatório!!!")
    public Date date;
    @NotBlank(message = "O campo de profissao é obrigatorio!!!")
    public Job job;
    @NotBlank(message = "O campo de telefone é obrigatório!!!")
    public String phone;
    @NotBlank(message = "O campo de endereço é obrigatório!!!")
    public String address;
    @NotBlank(message = "O campo de razão é obrigatório!!!")
    public String reason;
    @NotBlank(message = "O campo senha pe obrigatório!!!")
    @Size(min = 8,max = 20)
    public String password;
    @NotBlank(message = "o campo role é obrigatório!!!")
    public Role role;
}
