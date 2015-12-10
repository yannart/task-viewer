package com.gg.dao;

import java.util.List;

import com.gg.model.Task;

public interface TaskDao {

    List<Task> findAll();

}