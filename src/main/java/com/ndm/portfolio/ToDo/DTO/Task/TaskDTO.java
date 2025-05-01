package com.ndm.portfolio.ToDo.DTO.Task;

import com.ndm.portfolio.ToDo.Enum.Category.Category;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class TaskDTO {
    @NotBlank(message = "O campo nome ´r obrigatório!")
    public String name;
    @NotBlank(message = "O campo data é obrigatório!")
    public Date date;
    @NotBlank(message = "O campo category é obrigatório!")
    public Category category;
    @NotBlank(message = "O campo status é obrigatório!")
    public Boolean status;
}
