package org.zerock.todoapp.service;

import org.zerock.todoapp.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;

    public void register(TodoDTO todoDto) {
        System.out.println("DEBUG............." + todoDto);
    }

    public List<TodoDTO> getList() {

        List<TodoDTO> todoDTOS = IntStream.range(0, 10).mapToObj(i -> {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long) i);
            dto.setTitle("Todo.." + i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        return todoDTOS;
    }
}
