package com.todoList.maximeDev.Repository;

import com.todoList.maximeDev.Entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
}
