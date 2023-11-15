package com.todoList.maximeDev.DTO;

import com.todoList.maximeDev.Enum.TodoListState;

public class ToDoListDTO {

    private Long id;
    private String title;
    private String description;
    private TodoListState state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoListState getState() {
        return state;
    }

    public void setState(TodoListState state) {
        this.state = state;
    }
}
