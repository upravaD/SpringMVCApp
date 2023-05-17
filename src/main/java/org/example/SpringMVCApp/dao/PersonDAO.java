package org.example.SpringMVCApp.dao;

import org.example.SpringMVCApp.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    {
        people = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            people.add(new Person(i, "name"+i));
        }
    }

    public List<Person> getAll() {
        return people;
    }

    public Person getById(int id) {
        return people.stream()
                .filter(people -> people.getId() == id)
                .findAny()
                .orElse(null);
    }
}
