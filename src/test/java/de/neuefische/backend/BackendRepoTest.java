package de.neuefische.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class BackendRepoTest {

    @Test
    void getTodoById() {
        //GIVEN
        BackendRepo backendRepo = new BackendRepo();
        String id = "222";
        //WHEN
        Todo actual = backendRepo.getTodoById(id);
        //THEN
        Assertions.assertEquals(new Todo("222", "Blablablablablaa", Status.DONE),actual);
    }

    @Test
    void getTodoList() {
        //GIVEN
        List<Todo> todoList = new ArrayList<>();
        BackendRepo backendRepo = new BackendRepo(todoList);
        //WHEN
        List<Todo> actual = backendRepo.getTodoList();
        //THEN
        Assertions.assertEquals(List.of(
        ),actual);
    }

    @Test
    void testGetTodoById() {
        //GIVEN
        List<Todo> todoList = new ArrayList<>(
                List.of(
                        new Todo("222", "Blablablablablaa", Status.DONE),
                        new Todo("444", "Ahahahahahaha", Status.OPEN)
                )
        );
        BackendRepo backendRepo = new BackendRepo(todoList);
        //WHEN
        Todo actual = backendRepo.getTodoById("222");
        //THEN
        Assertions.assertEquals(new Todo("222", "Blablablablablaa", Status.DONE),actual);
    }

    @Test
    void putChangeItem() {
        //GIVEN
        List<Todo> todoList = new ArrayList<>(
                List.of(
                        new Todo("222", "Blablablablablaa", Status.DONE),
                        new Todo("444", "Ahahahahahaha", Status.OPEN)
                )
        );
        BackendRepo backendRepo = new BackendRepo(todoList);
        //WHEN
        Todo actual = backendRepo.putChangeItem("222",new Todo("222", "Ahahah", Status.DONE));
        //THEN
        Assertions.assertEquals(new Todo("222", "Ahahah", Status.DONE),actual);
    }

    @Test
    void deleteItem() {
        //GIVEN
        List<Todo> todoList = new ArrayList<>(
                List.of(
                        new Todo("222", "Blablablablablaa", Status.DONE),
                        new Todo("444", "Ahahahahahaha", Status.OPEN)
                )
        );
        BackendRepo backendRepo = new BackendRepo(todoList);
        //WHEN
        backendRepo.deleteItem("222",new Todo("222", "Ahahah", Status.DONE));
        //THEN
        Assertions.assertEquals(List.of(
                new Todo("444", "Ahahahahahaha", Status.OPEN)
        ),todoList);
    }
}