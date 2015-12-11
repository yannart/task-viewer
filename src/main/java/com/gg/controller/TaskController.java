package com.gg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gg.service.TaskService;

@Controller
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listTask(ModelMap model) {

        log.info("Task list view called.");
        model.addAttribute("tasks", taskService.listTasks());
        model.addAttribute("updated", taskService.lastUpdate());
        return "tasks";
    }

    @RequestMapping(value = "/flush", method = RequestMethod.GET)
    public void flush() {

        log.info("Flush called.");
        taskService.tasksUpdated();
    }
}
