package com.ndm.portfolio.ToDo.Model.User;

import com.ndm.portfolio.ToDo.DTO.User.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity(name = "TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String mail;
    private String job;
    private String phone;
    private String address;
    private String reason;
    private Date date;
    private String password;

    public User(int id, String name, String mail, String job, String phone, String address, String reason, Date date, String password) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.job = job;
        this.phone = phone;
        this.address = address;
        this.reason = reason;
        this.date = date;
        this.password = password;
    }

    public User() {}

    public User(UserDTO user){
        this.date = user.date;
        this.name = user.name;
        this.mail = user.email;
        this.job = user.job;
        this.phone = user.phone;
        this.address = user.address;
        this.reason = user.reason;
        this.password = user.password;
    }
}
