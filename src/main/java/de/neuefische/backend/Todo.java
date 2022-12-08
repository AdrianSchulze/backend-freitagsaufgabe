package de.neuefische.backend;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Todo {
    private String id;
    private String description;
    private Status status;
}
