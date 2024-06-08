package Clases;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private final List<Person> list;

    public PersonsList() {
        this.list = new ArrayList<>();
    }

    public void addPerson(Person person) {
        list.add(person);
    }

    public Person findByName(String name) {
        if (!name.matches("[a-zA-Z]+\\s[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }
        for (Person person : list) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person clone(Person original) {
        return new Person(generateNewId(), original.getName(), original.getAge(), original.getOccupation());
    }

    private int generateNewId() {
        return list.size() + 1; // Simple ID generation based on list size
    }

    public void writePersonToFile(Person person, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
