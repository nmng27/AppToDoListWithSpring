package com.ndm.portfolio.ToDo.Repository.Task;

import com.ndm.portfolio.ToDo.Model.Task.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {
    public List<Task> findByName(String name);
    public List<Task> findByStatus(Boolean status);
    public  List<Task> findByCategory(String category);
}
