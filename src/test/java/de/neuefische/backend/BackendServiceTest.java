package de.neuefische.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class BackendServiceTest {


    @Test
    void addTodo() {

    }

    @Test
    void getTodoList() {
        //GIVEN
        BackendRepo backendRepo = mock(BackendRepo.class);
        BackendService backendService = new BackendService(backendRepo);

        List<Todo> todoList = new ArrayList<>(
                List.of(
                        new Todo("222", "Blablablablablaa", Status.DONE),
                        new Todo("444", "Ahahahahahaha", Status.OPEN)
                ));

        //WHEN & THEN
        when(backendRepo.getTodoList()).thenReturn(todoList);
        List<Todo> actual = backendService.getTodoList();

        Assertions.assertEquals(todoList,actual);
        verify(backendRepo).getTodoList();
    }

    @Test
    void getTodoById() {
        //GIVEN
        BackendRepo backendRepo = mock(BackendRepo.class);
        BackendService backendService = new BackendService(backendRepo);

        //WHEN & THEN
        when(backendRepo.getTodoById("222")).thenReturn(new Todo("222", "Blablablablablaa", Status.DONE));
        Todo actual = backendService.getTodoById("222");

        Assertions.assertEquals(new Todo("222", "Blablablablablaa", Status.DONE),actual);
        verify(backendRepo).getTodoById("222");
    }

    @Test
    void putChangeItem() {
        BackendRepo backendRepo = mock(BackendRepo.class);
        BackendService backendService = new BackendService(backendRepo);
        Todo todo1 = new Todo("222", "Blablablablablaa", Status.DONE);

        List<Todo> todoList = new ArrayList<>(
                List.of(
                        new Todo("222", "Blablablablablaa", Status.DONE),
                        new Todo("444", "Ahahahahahaha", Status.OPEN)
                ));
        //WHEN
        when(backendRepo.putChangeItem("222", todo1)).thenReturn(new Todo("222", "Ahahah", Status.DONE));
        Todo actual = backendService.putChangeItem("222",todo1);
        //THEN
        Assertions.assertEquals(new Todo("222", "Ahahah", Status.DONE),actual);
        verify(backendRepo).putChangeItem("222", todo1);
    }

    @Test
    void deleteItem() {
        //GIVEN
        BackendRepo backendRepo = mock(BackendRepo.class);
        BackendService backendService = new BackendService(backendRepo);
        List<Todo> todoList = new ArrayList<>(
                List.of(
                        new Todo("222", "Blablablablablaa", Status.DONE),
                        new Todo("444", "Ahahahahahaha", Status.OPEN)
                )
        );

        //WHEN & THEN
       // when(backendRepo.deleteItem("222", new Todo("222", "Blablablablablaa", Status.DONE))).thenReturn(new Todo("", "");
        backendService.deleteItem("222");
        List<Todo> actual = todoList;
        Assertions.assertEquals(List.of(
                new Todo("444", "Ahahahahahaha", Status.OPEN)
        ),actual);
        verify(backendRepo).deleteItem("222", new Todo("222", "Blablablablablaa", Status.DONE));
    }
}