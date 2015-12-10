package com.gg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gg.dao.TaskDao;

@Controller
public class TaskController {

    @Autowired
    TaskDao taskDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listTask(ModelMap model) {
        model.addAttribute("tasks", taskDao.findAll());
        return "tasks";
    }
}