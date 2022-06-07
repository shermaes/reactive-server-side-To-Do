package com.sofkau.serversideToDo.dto;

import java.util.Objects;

public class ToDoDTO {
    private String todo;

    public ToDoDTO(String todo) {
        this.todo = todo;
    }

    public ToDoDTO() {
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoDTO toDoDTO = (ToDoDTO) o;
        return Objects.equals(todo, toDoDTO.todo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todo);
    }

    @Override
    public String toString() {
        return "ToDoDTO{" +
                "todo='" + todo + '\'' +
                '}';
    }
}
