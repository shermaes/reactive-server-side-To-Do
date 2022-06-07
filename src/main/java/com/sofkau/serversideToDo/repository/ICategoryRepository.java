package com.sofkau.serversideToDo.repository;

import com.sofkau.serversideToDo.collection.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ICategoryRepository extends ReactiveMongoRepository<Category, String> {
}
