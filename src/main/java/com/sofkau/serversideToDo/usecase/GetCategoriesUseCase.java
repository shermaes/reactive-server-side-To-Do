package com.sofkau.serversideToDo.usecase;

import com.sofkau.serversideToDo.dto.CategoryDTO;
import com.sofkau.serversideToDo.mapper.TodoMapper;
import com.sofkau.serversideToDo.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetCategoriesUseCase {
    private ICategoryRepository iCategoryRepository;
    private TodoMapper todoMapper;

    public Flux<CategoryDTO> apply(){
        return iCategoryRepository.findAll().map(todoMapper::toCategoryDTO);
    }
}
