package org.ironhack.lab204;

import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new IllegalArgumentException("Name not found");
    }

    public Person clone(Person person) {
        return new Person(0, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writeToFile(Person person) {
        // Implement this method to write the person's information to a file

    }
}
