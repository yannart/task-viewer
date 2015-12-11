package com.gg.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.dao.TaskDao;
import com.gg.model.Task;

@Service
public class TaskServiceImpl implements TaskService {

    Log log = LogFactory.getLog(TaskServiceImpl.class);

    @Autowired
    TaskDao taskDao;

    private boolean cacheInvalidated = true;

    List<Task> cachedTasks = new ArrayList<Task>();

    @Override
    public List<Task> listTasks() {

        log.info("Listing the tasks.");

        if (cacheInvalidated) {
            log.info("The cache is not valid, refreshing the list of tasks.");
            List<Task> newCachedTasks = taskDao.findAll();

            synchronized (this) {
                cachedTasks = newCachedTasks;
                cacheInvalidated = false;
            }
        }

        return cachedTasks;
    }

    @Override
    public void tasksUpdated() {

        log.info("The list of tasks has been updated, marking the cache as not valid.");

        synchronized (this) {
            cacheInvalidated = true;
        }
    }

}
