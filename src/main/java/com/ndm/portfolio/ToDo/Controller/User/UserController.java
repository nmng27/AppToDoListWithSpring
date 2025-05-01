package com.ndm.portfolio.ToDo.Controller.User;

import com.ndm.portfolio.ToDo.DTO.Login.LoginDTO;
import com.ndm.portfolio.ToDo.DTO.User.UserDTO;
import com.ndm.portfolio.ToDo.Model.User.User;
import com.ndm.portfolio.ToDo.Repository.User.UserRepository;
import com.ndm.portfolio.ToDo.Service.User.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDTO user) {
        try{
            User new_user = userService.register(user);
            return  ResponseEntity.ok(new_user);
        }catch(HttpClientErrorException.NotFound ex){
            return  ResponseEntity.notFound().build();
        }catch(HttpClientErrorException.BadRequest ex){
            return  ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDTO credentials) {
        try{
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(credentials.username,credentials.password);
            return ResponseEntity.ok().build();
        }catch(HttpClientErrorException.NotFound ex){
            return  ResponseEntity.notFound().build();
        }catch (HttpClientErrorException.BadRequest ex){
            return  ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        try{
            User search = userService.GetById(id);
            return  ResponseEntity.ok(search);
        }catch(HttpClientErrorException.NotFound ex){
            return  ResponseEntity.notFound().build();
        }catch (HttpClientErrorException.BadRequest ex){
            return  ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        try{
            List<User> getAll = userService.GetAll();
            return  ResponseEntity.ok(getAll);
        }catch(HttpClientErrorException.NotFound ex){
            return  ResponseEntity.notFound().build();
        }catch (HttpClientErrorException.BadRequest ex){
            return  ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody UserDTO user) {
        try{
            User search = userService.update(user, id);
            return ResponseEntity.ok(search);
        }catch(HttpClientErrorException.NotFound ex){
            return  ResponseEntity.notFound().build();
        }catch (HttpClientErrorException.BadRequest ex){
            return  ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        try{
            userService.delete(id);
            return ResponseEntity.ok("Dados excluídos com sucesso!");
        }catch(HttpClientErrorException.NotFound ex){
            return  ResponseEntity.notFound().build();
        }catch (HttpClientErrorException.BadRequest ex){
            return  ResponseEntity.badRequest().build();
        }
    }
}
