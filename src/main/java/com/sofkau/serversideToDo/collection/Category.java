package com.sofkau.serversideToDo.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Document(collection="todos")
public class Category {
    @Id
    private String id;
    @NotBlank
    private String title;
    private String message;
    private List<ToDo> todos;

}
