package com.gg.model;

public class Task {

    private int id;
    private String taskName;
    private String taskDescription;
    private String taskPriority;
    private String taskStatus;
    private boolean taskArchived = false;

    public int getTaskId() {
        return id;
    }

    public void setTaskId(int taskId) {
        this.id = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public boolean isTaskArchived() {
        return taskArchived;
    }

    public void setTaskArchived(boolean taskArchived) {
        this.taskArchived = taskArchived;
    }

    @Override
    public String toString() {
        return "Task " + id + ": " + taskName + " -- " + taskDescription
                + " - " + taskPriority + " - " + taskStatus;
    }
}
