package com.gg.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.dao.TaskDao;
import com.gg.model.Task;

@Service
public class TaskServiceImpl implements TaskService {

    //private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    TaskDao taskDao;

    private boolean cacheInvalidated = true;

    private List<Task> cachedTasks = new ArrayList<Task>();

    private Date lastUpdate = null;

    @Override
    public Date lastUpdate() {
        return lastUpdate;
    }

    @Override
    public List<Task> listTasks() {

        //log.info("Listing the tasks.");

        if (cacheInvalidated) {
            //log.info("The cache is not valid, refreshing the list of tasks.");
            List<Task> newCachedTasks = taskDao.findAll();

            synchronized (this) {
                cachedTasks = newCachedTasks;
                cacheInvalidated = false;
                lastUpdate = new Date();
            }
        }

        return cachedTasks;
    }

    @Override
    public void tasksUpdated() {

        //log.info("The list of tasks has been updated, marking the cache as not valid.");

        synchronized (this) {
            cacheInvalidated = true;
        }
    }

}
