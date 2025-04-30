package com.ndm.portfolio.ToDo.Service.User;

import com.ndm.portfolio.ToDo.DTO.User.UserDTO;
import com.ndm.portfolio.ToDo.Model.User.User;
import com.ndm.portfolio.ToDo.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User register(UserDTO dto){
        try{
            User new_user = new User(dto);
            userRepository.save(new_user);
            return new_user;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public User update(UserDTO dto, int id){
        try{
            User new_user = userRepository.findById(id).get();
            new_user.setName(dto.name);
            new_user.setMail(dto.email);
            new_user.setAddress(dto.address);
            new_user.setPhone(dto.phone);
            new_user.setDate(dto.date);
            new_user.setJob(dto.job);
            new_user.setReason(dto.reason);
            new_user.setPassword(dto.password);
            userRepository.save(new_user);
            return new_user;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void delete(int id){
        try{
            userRepository.deleteById(id);

        }catch(Exception e){
            e.printStackTrace();

        }
    }

    public List<User> GetAll(){
        try{
            List<User> users = userRepository.findAll();
            return users;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public User    GetById(int id){
        try{
            User user = userRepository.findById(id).get();
            return user;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
