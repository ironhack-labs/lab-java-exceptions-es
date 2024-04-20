package org.example;

import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void add(Person person) {
        this.persons.add(person);
    }

    public Person findByName(String name) {
        String[] parts = name.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Name should be formatted as 'firstName lastName'");
        }

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person clone(Person original) {
        int newId = this.persons.size() + 1; // Simplemente para tener un nuevo 'id', una estrategia diferente puede ser necesaria
        return new Person(newId, original.getName(), original.getAge(), original.getOccupation());
    }
}
