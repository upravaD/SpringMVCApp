package org.example.SpringMVCApp.models;

import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
    private int id;
    @NotNull(message = "The name cannot be empty.")
    @Size(min = 2, max = 30, message = "Incorrect name size.")
    private String name;
    @Min(value = 0, message = "Negative age.")
    @Max(value = 120, message = "Non-existent age.")
    private int age;
    @NotNull(message = "The e-mail cannot be empty.")
    @Email(message = "Incorrect email.")
    private String email;
}
