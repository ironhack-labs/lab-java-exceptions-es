package org.example.classes;

import org.example.utils.Validator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersonList  {
    private ArrayList<Person> persons;

    public PersonList () {
        persons = new ArrayList<>();
    }

    public void addIndividual(Person person) {
        persons.add(person);
    }

    public void clearAll() {
        persons.clear();
    }

    public Person searchByName(String fullName) {
        Validator.checkName(fullName);
        Person result;

        for (Person person : persons) {
            if (person.getFullName().equals(fullName)) {
                result = person;
                return result;
            }
        }
        throw new UnsupportedOperationException("FullName not found");
    }

    public Person clone(Person p) {
        return new Person(p.getFullName(),p.getYears(),p.getJobTitle());
    }

    public void  getInformation (Person p) throws IOException {
        File file = new File("src/main/resources/personFiles/" + p.getFullName() + ".csv");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write(p.toString());
        fileWriter.close();
    }


}
