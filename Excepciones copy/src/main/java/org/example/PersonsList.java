package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private final List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public Person findByName(String name) {
        String[] nameParts = name.split(" ");
        if (nameParts.length != 2) {
            throw new IllegalArgumentException("Name should be formatted as 'firstName lastName'");
        }
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        for (Person person : persons) {
            if (person.getName().equals(firstName + lastName)) {
                return person;
            }
        }
        throw new IllegalArgumentException("Person with name '" + name + "' not found");
    }

    public Person clonePerson(Person original) {
        return new Person(-1, original.getName(), original.getAge(), original.getOccupation());
    }

    public void writeToFile(Person person, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(person.toString());
            System.out.println("Person information written to file successfully");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
