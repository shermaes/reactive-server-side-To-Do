package com.sofkau.serversideToDo.dto;

import com.sofkau.serversideToDo.collection.ToDo;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;
@Data
public class CategoryDTO {

    private String id;

    @NotBlank(message = "Title can't be blank")
    private String title;

    @NotBlank(message = "Message can't be blank")
    private String message;

    private List<ToDo> toDos;
}
