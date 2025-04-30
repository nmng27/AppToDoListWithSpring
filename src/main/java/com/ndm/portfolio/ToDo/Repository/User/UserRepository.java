package com.ndm.portfolio.ToDo.Repository.User;

import com.ndm.portfolio.ToDo.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmailAndPassword(String email, String password);
}
