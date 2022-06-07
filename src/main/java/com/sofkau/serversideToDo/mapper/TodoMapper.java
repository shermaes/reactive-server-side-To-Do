package com.sofkau.serversideToDo.mapper;

import com.sofkau.serversideToDo.collection.Category;
import com.sofkau.serversideToDo.collection.ToDo;
import com.sofkau.serversideToDo.dto.CategoryDTO;
import com.sofkau.serversideToDo.dto.ToDoDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
@RequiredArgsConstructor
public class TodoMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public CategoryDTO toCategoryDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    public Category toEntity(CategoryDTO dto) {
        return modelMapper.map(dto, Category.class);
    }

    public ToDoDTO toToDoDTO(ToDo todo) {
        return modelMapper.map(todo, ToDoDTO.class);
    }

    public ToDo toEntity(ToDoDTO dto) {
        return modelMapper.map(dto, ToDo.class);
    }

}