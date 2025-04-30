package com.ndm.portfolio.ToDo.Model.Task;

import com.ndm.portfolio.ToDo.DTO.Task.TaskDTO;

import java.util.Date;

public class Task {
    private int id;
    private String name;
    private Date date;
    private String category;
    private Boolean status;

    public Task(int id, String name, Date date, String category, Boolean status) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.category = category;
        this.status = status;
    }

    public Task(){}

    public Task(TaskDTO taskDTO) {
        this.name = taskDTO.name;
        this.date = taskDTO.date;
        this.category = taskDTO.category;
        this.status = taskDTO.status;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
