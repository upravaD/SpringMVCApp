package org.example.SpringMVCApp.dao;

import org.example.SpringMVCApp.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PersonDAO {
    private static int ID_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            people.add(new Person(++ID_COUNT, "name"+i, new Random().nextInt(5,100), i+"@mail.ru"));
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

    public void save(Person person) {
        person.setId(++ID_COUNT);
        people.add(person);
    }

    public void update(Person newPerson, int id) {
        Person oldPerson = getById(id);
        oldPerson.setName(newPerson.getName());
        oldPerson.setAge(newPerson.getAge());
        oldPerson.setEmail(newPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
