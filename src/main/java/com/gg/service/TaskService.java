package com.gg.service;

import java.util.List;

import com.gg.model.Task;

public interface TaskService {

    List<Task> listTasks();
    
    void tasksUpdated();
}
