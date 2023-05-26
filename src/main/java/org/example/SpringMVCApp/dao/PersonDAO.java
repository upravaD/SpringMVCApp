package org.example.SpringMVCApp.dao;

import org.example.SpringMVCApp.models.Person;
import org.example.SpringMVCApp.util.PostgresInit;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PersonDAO {
    private static int ID_COUNT;
    private int randomId = new Random().nextInt(100);

//    private List<Person> people;
//    {
//        people = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            people.add(new Person(
//                    ++ID_COUNT,
//                    "name"+i,
//                    new Random().nextInt(5,100),
//                    i+"@mail.ru")
//            );
//        }
//    }

    private final Connection connection;
    {
        try {
            connection = PostgresInit.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> getAll() {
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    public Person getById(int id) {
//        return people.stream()
//                .filter(people -> people.getId() == id)
//                .findAny()
//                .orElse(null);
        Person person;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Person WHERE id = ?"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            person = new Person(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    resultSet.getString("email")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public void save(Person person) {
//        person.setId(++ID_COUNT);
//        people.add(person);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into person VALUES (?, ?, ?, ?);");

            preparedStatement.setInt(1, randomId);
            preparedStatement.setString(2, person.getName());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setString(4, person.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Person newPerson, int id) {
//        Person oldPerson = getById(id);
//        oldPerson.setName(newPerson.getName());
//        oldPerson.setAge(newPerson.getAge());
//        oldPerson.setEmail(newPerson.getEmail());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Person SET name = ?, age = ?, email = ? WHERE id = ?"
            );
            preparedStatement.setString(1, newPerson.getName());
            preparedStatement.setInt(2, newPerson.getAge());
            preparedStatement.setString(3, newPerson.getEmail());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
//        people.removeIf(p -> p.getId() == id);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Person WHERE id = ?"
            );
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
