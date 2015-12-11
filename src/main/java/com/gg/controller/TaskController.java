package com.gg.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gg.service.TaskService;

@Controller
public class TaskController {

    Log log = LogFactory.getLog(TaskController.class);

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listTask(ModelMap model) {
        
        log.info("Task list view called.");
        model.addAttribute("tasks", taskService.listTasks());
        return "tasks";
    }

    @RequestMapping(value = "/flush", method = RequestMethod.GET)
    public void flush() {
        
        log.info("Flush called.");
        taskService.tasksUpdated();
    }
}
