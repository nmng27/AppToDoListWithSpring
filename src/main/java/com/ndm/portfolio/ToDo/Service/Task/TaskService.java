package com.ndm.portfolio.ToDo.Service.Task;

import com.ndm.portfolio.ToDo.DTO.Task.TaskDTO;
import com.ndm.portfolio.ToDo.Model.Task.Task;
import com.ndm.portfolio.ToDo.Repository.Task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(TaskDTO task) {
        try{
            Task new_task = new Task(task);
            return  taskRepository.save(new_task);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Task update(TaskDTO dto, int id){
        try{
            Task search = taskRepository.findById(id).get();
            search.setDate(dto.date);
            search.setCategory(dto.category);
            search.setName(dto.name);
            search.setStatus(dto.status);
            return  taskRepository.save(search);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public void delete(int id) {
        try{
            taskRepository.deleteById(id);
        }catch(Exception ex){
            ex.printStackTrace();

        }
    }

    public Task findById(int id) {
        try{
            Task search = taskRepository.findById(id).get();
            return search;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<Task> getAll(){
        try{
            List<Task> all = (List<Task>) taskRepository.findAll();
            return all;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<Task> getAllByName(String name){
        try{
            List<Task> all = taskRepository.findByName(name);
            return all;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<Task> getAllByStatus(Boolean status){
        try{
            List<Task> all = taskRepository.findByStatus(status);
            return all;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<Task> getAllByCategory(String category){
        try{
            List<Task> all = taskRepository.findByCategory(category);
            return all;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
