package com.sofkau.serversideToDo;

import com.sofkau.serversideToDo.mapper.TodoMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerSideToDoApplication {

	public static void main(String[] args) {SpringApplication.run(ServerSideToDoApplication.class, args);
	}

	@Bean
	public TodoMapper todoMapper(){
		return new TodoMapper();
	}
}
