package com.sofkau.serversideToDo.router;

import com.sofkau.serversideToDo.collection.Category;
import com.sofkau.serversideToDo.collection.ToDo;
import com.sofkau.serversideToDo.dto.CategoryDTO;
import com.sofkau.serversideToDo.mapper.TodoMapper;
import com.sofkau.serversideToDo.repository.ICategoryRepository;
import com.sofkau.serversideToDo.usecase.GetCategoriesUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;



@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {GetCategoriesRoute.class, GetCategoriesUseCase.class, TodoMapper.class})
public class GetCategoriesRouteTest {
    @MockBean
    private ICategoryRepository iCategoryRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGetAllCategories() {
        Category category1 = new Category();
        category1.setId("1");
        category1.setTitle("Primera Categoria");
        category1.setMessage("Hogar");
        List<ToDo> todos1 = new ArrayList<>();
        todos1.add(new ToDo("Planchar"));
        todos1.add(new ToDo("Lavar"));
        todos1.add(new ToDo("Cocinar"));
        category1.setTodos(todos1);
        Category category2 = new Category();
        category2.setId("2");
        category2.setTitle("Segunda Categoria");
        category2.setMessage("Universidad");
        List<ToDo> todos2 = new ArrayList<>();
        todos2.add(new ToDo("Estudiar"));
        todos2.add(new ToDo("Estudiar mas"));
        todos2.add(new ToDo("Seguir estudiando"));
        category2.setTodos(todos2);

        Mockito.when(iCategoryRepository.findAll())
                .thenReturn(Flux.just(category1, category2));

        webTestClient.get()
                .uri("/v1/api/categories")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(CategoryDTO.class)
                .value(userResponse -> {
                    Assertions.assertThat(userResponse.get(0).getId()).isEqualTo(category1.getId());
                    Assertions.assertThat(userResponse.get(0).getMessage()).isEqualTo(category1.getMessage());
                    Assertions.assertThat(userResponse.get(0).getTitle()).isEqualTo(category1.getTitle());
                    Assertions.assertThat(userResponse.get(0).getToDos()).isEqualTo(category1.getTodos());
                    Assertions.assertThat(userResponse.get(1).getId()).isEqualTo(category2.getId());
                    Assertions.assertThat(userResponse.get(1).getTitle()).isEqualTo(category2.getTitle());
                    Assertions.assertThat(userResponse.get(1).getMessage()).isEqualTo(category2.getMessage());
                    Assertions.assertThat(userResponse.get(1).getToDos()).isEqualTo(category2.getTodos());
                });
    }
}