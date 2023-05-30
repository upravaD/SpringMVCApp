package org.example.SpringMVCApp.dao;

import org.example.SpringMVCApp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class PersonDAO {
    private JdbcTemplate jdbcTemplate;
    private int randomId = new Random().nextInt(100);

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Person",
                new BeanPropertyRowMapper<>(Person.class)
        );
    }

    public Person getById(int id) {
        return jdbcTemplate.query(
                "SELECT * FROM Person WHERE id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)
        ).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update(
                "INSERT INTO Person VALUES (?, ?, ?, ?);",
                randomId,
                person.getName(),
                person.getAge(),
                person.getName()
        );
    }

    public void update(Person newPerson, int id) {
        jdbcTemplate.update(
                "UPDATE Person SET name = ?, age = ?, email = ? WHERE id = ?",
                newPerson.getName(),
                newPerson.getAge(),
                newPerson.getEmail(),
                id
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id = ?", id);
    }
}
