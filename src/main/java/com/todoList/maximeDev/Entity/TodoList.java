package com.todoList.maximeDev.Entity;

import com.todoList.maximeDev.DTO.ToDoListDTO;
import com.todoList.maximeDev.Enum.TodoListState;
import jakarta.persistence.*;

@Entity
@Table(name = "todo_list")
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    private TodoListState state;

    public TodoList() {
    }

    public TodoList(String title, String description) {
        this.title = title;
        this.description = description;
    }

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
