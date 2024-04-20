package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    public List<Person> persons;
    private static int count = 0;


    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPersons(Person person) {
        persons.add(person);
        count++;
    }

    public Person findByName(String name){
        if (!name.contains(" "))
            throw new IllegalArgumentException("El parámetro name no está formateado adecuadamente");

        String[] nameParts = name.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new IllegalArgumentException("No se encontró ninguna persona con el nombre proporcionado");
    }

    public Person clone(Person person){
        return new Person(generateNewId(), person.getName(), person.getAge(), person.getOccupation());
    }

    public int generateNewId(){
        return ++count;
    }

    public void writeToFile(Person person) {
        try (FileWriter writer = new FileWriter("person.txt")) {
            writer.write(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
