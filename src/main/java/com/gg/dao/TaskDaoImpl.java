package com.gg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.gg.model.Task;

@Repository
public class TaskDaoImpl implements TaskDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Task> findAll() {
        List<Task> tasks = this.jdbcTemplate
                .query("select id, task_name, task_description, task_priority, task_status, task_archived from task",
                        new RowMapper<Task>() {
                            public Task mapRow(ResultSet rs, int rowNum)
                                    throws SQLException {
                                Task task = new Task();
                                task.setTaskId(rs.getInt("id"));
                                task.setTaskName(rs.getString("task_name"));
                                task.setTaskDescription(rs
                                        .getString("task_description"));
                                task.setTaskPriority(rs
                                        .getString("task_priority"));
                                task.setTaskStatus(rs.getString("task_status"));
                                task.setTaskArchived(rs
                                        .getBoolean("task_archived"));
                                return task;
                            }
                        });

        return tasks;
    }

}