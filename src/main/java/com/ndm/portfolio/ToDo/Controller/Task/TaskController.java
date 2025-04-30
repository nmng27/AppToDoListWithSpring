package com.ndm.portfolio.ToDo.Controller.Task;

import com.ndm.portfolio.ToDo.DTO.Task.TaskDTO;
import com.ndm.portfolio.ToDo.Model.Task.Task;
import com.ndm.portfolio.ToDo.Service.Task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> create(TaskDTO task) {
        try{
            Task new_task = taskService.createTask(task);
            return ResponseEntity.ok(new_task);
        }catch(HttpClientErrorException.BadRequest ex){
            return ResponseEntity.badRequest().build();
        }catch(HttpClientErrorException.NotFound ex){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody TaskDTO task, @PathVariable int id) {
        try{
            Task task_upd = taskService.update(task, id);
            return ResponseEntity.ok(task_upd);
        }catch(HttpClientErrorException.BadRequest ex){
            return ResponseEntity.badRequest().build();
        }catch(HttpClientErrorException.NotFound ex){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAll() {
        try{
            List<Task> tasks = taskService.getAll();
            return ResponseEntity.ok(tasks);
        }catch(HttpClientErrorException.BadRequest ex){
            return ResponseEntity.badRequest().build();
        }catch(HttpClientErrorException.NotFound ex){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<Task>> getTask(@PathVariable Boolean status) {
        try{
            List<Task> tasks = taskService.getAllByStatus(status);
            return ResponseEntity.ok(tasks);
        }catch(HttpClientErrorException.BadRequest ex){
            return ResponseEntity.badRequest().build();
        }catch(HttpClientErrorException.NotFound ex){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Task>> getAllByName(String name) {
        try{
            List<Task> tasks = taskService.getAllByName(name);
            return ResponseEntity.ok(tasks);
        }catch(HttpClientErrorException.BadRequest ex){
            return ResponseEntity.badRequest().build();
        }catch(HttpClientErrorException.NotFound ex){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id) {
        try{
            Task task = taskService.findById(id);
            return ResponseEntity.ok(task);
        }catch(HttpClientErrorException.BadRequest ex){
            return ResponseEntity.badRequest().build();
        }catch(HttpClientErrorException.NotFound ex){
            return ResponseEntity.notFound().build();
        }
    }


}
