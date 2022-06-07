package com.sofkau.serversideToDo.router;

import com.sofkau.serversideToDo.dto.CategoryDTO;
import com.sofkau.serversideToDo.usecase.GetCategoriesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetCategoriesRoute {
    @Bean
    public RouterFunction<ServerResponse> allCategories(GetCategoriesUseCase get) {
        return route(GET("/v1/api/categories"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(get.apply(), CategoryDTO.class))
        );
    }
}
