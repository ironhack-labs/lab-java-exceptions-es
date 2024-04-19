package org.example.employee;

import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons;
    public PersonsList(){
        persons = new ArrayList<>();
    }
    public Person findByName (String name){
        for(Person person : persons){
            if (person.getName().equals(name)){
                return person;
            }
        }
    throw new IllegalArgumentException("Dont found this person: " + name);
    }
    public Person clone(Person otherPerson){
        int newId = persons.size() + 4;
        return new Person(newId, otherPerson.getName(), otherPerson.getAge(), otherPerson.getOccupation());
    }

    public void addPerson(Person person) {
        persons.add(person);
    }
}
