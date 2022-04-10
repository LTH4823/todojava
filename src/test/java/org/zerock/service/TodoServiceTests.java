package org.zerock.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.s1.todo.dto.TodoDTO;
import org.zerock.s1.todo.service.TodoService;

import java.time.LocalDate;

@Log4j2
public class TodoServiceTests {

    private TodoService todoService;

    @BeforeEach
    public void ready(){
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister()throws Exception{
        TodoDTO todoDTO = TodoDTO.builder()
                .title("JDBC TEST TITLE")
                .dueDate(LocalDate.now())
                .build();

        log.info("--------------------------"); //log4j2
        log.info(todoDTO);

        todoService.register(todoDTO);
    }
}
