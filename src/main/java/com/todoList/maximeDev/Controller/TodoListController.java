package com.todoList.maximeDev.Controller;

import com.todoList.maximeDev.DTO.ToDoListDTO;
import com.todoList.maximeDev.Entity.TodoList;
import com.todoList.maximeDev.Mapper.TodoListMapper;
import com.todoList.maximeDev.Services.TodoListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/todolists")
public class TodoListController {

    private final TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @PostMapping("/")
    public ToDoListDTO createTodoList(@RequestBody ToDoListDTO todoListDTO) {
        TodoList todoList = todoListService.createTodoList(TodoListMapper.toEntity(todoListDTO));
        return TodoListMapper.toDto(todoList);
    }

    @GetMapping("/")
    public List<ToDoListDTO> getAllTodoLists() {
        return todoListService.getAllTodoLists().stream()
                .map(TodoListMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoListDTO> getTodoListById(@PathVariable(value = "id") Long id) {
        return todoListService.getTodoListById(id)
                .map(todoList -> ResponseEntity.ok(TodoListMapper.toDto(todoList)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoListDTO> updateTodoList(@PathVariable(value = "id") Long id, @RequestBody ToDoListDTO todoListDTO) {
        try {
            TodoList updatedTodoList = todoListService.updateTodoList(id, TodoListMapper.toEntity(todoListDTO));
            return ResponseEntity.ok(TodoListMapper.toDto(updatedTodoList));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoList(@PathVariable(value = "id") Long id) {
        try {
            todoListService.deleteTodoList(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
