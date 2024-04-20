package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PersonsList {
    private List<Person> personList;

    public PersonsList(){
        this.personList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public Person findByName(String name) {
        if (!isValidNameFormat(name)) {
            throw new IllegalArgumentException("Invalid name format. Name must be in camel case.");
        }

        for (Person person : personList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    private boolean isValidNameFormat(String name) {
        return name.matches("[a-zA-Z]+(\\s[a-zA-Z]+)*");
    }


    public Person clone(Person originalPerson) {
        Random random = new Random();
        int newId = random.nextInt(1000); // chooses random ID
        String name = originalPerson.getName();
        int age = originalPerson.getAge();
        String occupation = originalPerson.getOccupation();

        return new Person(newId, name, age, occupation);
    }


}