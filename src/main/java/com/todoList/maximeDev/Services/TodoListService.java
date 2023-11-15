package com.todoList.maximeDev.Services;

import com.todoList.maximeDev.Entity.TodoList;
import com.todoList.maximeDev.Repository.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListService {

    private final TodoListRepository todoListRepository;

    TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public TodoList createTodoList(TodoList todoList) {
        return todoListRepository.save(todoList);
    }

    public List<TodoList> getAllTodoLists() {
        return todoListRepository.findAll();
    }

    public Optional<TodoList> getTodoListById(Long id) {
        return todoListRepository.findById(id);
    }

    public TodoList updateTodoList(Long id, TodoList todoListDetails) {
        TodoList todoList = todoListRepository.findById(id).orElseThrow(
                () -> new RuntimeException("TodoList not found for this id :: " + id));
        todoList.setTitle(todoListDetails.getTitle());
        todoList.setDescription(todoListDetails.getDescription());
        todoList.setState(todoListDetails.getState());
        return todoListRepository.save(todoList);
    }

    public void deleteTodoList(Long id) {
        TodoList todoList = todoListRepository.findById(id).orElseThrow(
                () -> new RuntimeException("TodoList not found for this id :: " + id));
        todoListRepository.delete(todoList);
    }
}
