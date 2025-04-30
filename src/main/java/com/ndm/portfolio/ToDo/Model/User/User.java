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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
