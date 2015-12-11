package com.gg.service;

import java.util.Date;
import java.util.List;

import com.gg.model.Task;

public interface TaskService {

    Date lastUpdate();
    
    List<Task> listTasks();
    
    void tasksUpdated();
}
