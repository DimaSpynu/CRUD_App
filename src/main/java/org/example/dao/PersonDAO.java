package org.example.dao;

import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());
    }

    public Person show(final int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.query("INSERT INTO Person VALUES (1, ?, ?, ?)", new PersonMapper());
    }

    public void update(int id, Person updatePerson) {
        jdbcTemplate.query("UPDATE person SET name=?, age=?, email=? WHERE id=?", new PersonMapper());
    }

    public void delete(int id) {
        jdbcTemplate.query("DELETE FROM person WHERE id=?", new PersonMapper());
    }
}
