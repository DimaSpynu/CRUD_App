package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "Tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 46, "Bob@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 15, "Mike@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 30, "Katy@mail.ru"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(final int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());

    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
