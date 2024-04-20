package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void add(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) {
        String[] parts = name.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("El nombre debe estar formateado como 'nombreApellido'");
        }
        String firstName = parts[0];
        String lastName = parts[1];
        for (Person person : persons) {
            String[] personNameParts = person.getName().split(" ");
            if (personNameParts.length == 2 && personNameParts[0].equals(firstName) && personNameParts[1].equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    public Person clone(Person original) {
        Person clone = new Person(original.getId(), original.getName(), original.getAge(), original.getOccupation());
        String[] parts = clone.getName().split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("El nombre debe estar formateado como 'nombreApellido'");
        }
        return clone;
    }

    public void writeFile(Person person) {
        try {
            FileWriter writer = new FileWriter("person_info.txt");
            writer.write(person.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
