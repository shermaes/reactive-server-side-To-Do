package com.sofkau.serversideToDo.collection;


import java.util.Objects;

public class ToDo {

    private String todos;

    public ToDo() {
    }

    public ToDo(String todos) {
        this.todos = todos;
    }
    public String getTodos() {
        return todos;
    }

    public void setTodos(String todos) {
        this.todos = todos;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "todos='" + todos + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return todos.equals(toDo.todos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todos);
    }
}
