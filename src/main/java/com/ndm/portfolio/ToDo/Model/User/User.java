package com.ndm.portfolio.ToDo.Model.User;

import com.ndm.portfolio.ToDo.DTO.User.UserDTO;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity(name = "TB_USER")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String mail;
    private String job;
    private String phone;
    private String address;
    @Column(name = "REASON_SEARCH")
    private String reason;
    @Column(name = "DATE_OF_BIRTH")
    private Date date;
    private String password;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String name, String mail, String job, String phone, String address,String role, String reason, Date date, String password) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.job = job;
        this.phone = phone;
        this.address = address;
        this.reason = reason;
        this.date = date;
        this.role = role;
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
        this.role = user.role;
    }
}
