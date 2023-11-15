package com.todoList.maximeDev.Mapper;

import com.todoList.maximeDev.Entity.TodoList;
import com.todoList.maximeDev.DTO.ToDoListDTO;

public class TodoListMapper {

    public static ToDoListDTO toDto(TodoList todoList) {
        if (todoList == null) {
            return null;
        }

        ToDoListDTO dto = new ToDoListDTO();
        dto.setId(todoList.getId());
        dto.setTitle(todoList.getTitle());
        dto.setDescription(todoList.getDescription());
        dto.setState(todoList.getState());
        return dto;
    }

    public static TodoList toEntity(ToDoListDTO dto) {
        if (dto == null) {
            return null;
        }

        TodoList todoList = new TodoList();
        todoList.setId(dto.getId());
        todoList.setTitle(dto.getTitle());
        todoList.setDescription(dto.getDescription());
        todoList.setState(dto.getState());
        return todoList;
    }
}
