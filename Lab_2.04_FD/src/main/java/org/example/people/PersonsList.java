package org.example.people;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
    public void writeToFile(Person person, String filename){
        try(FileWriter writer = new FileWriter(filename)){
            writer.write(person.toString());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }

    public void addPerson(Person person) {
        persons.add(person);
    }

 @Test
    public void testFindByNameValid(){
     PersonsList personsList = new PersonsList();
     Person person = new Person(2,"Boris Riera",34,"Programmer");
     personsList.addPerson(person);
     Person foundPerson = personsList.findByName("Boris Riera");
     assertEquals(person,foundPerson);
 }

 @Test
    public void testFindByNameInvalid(){
     PersonsList personsList = new PersonsList();
     Person person = new Person(2,"Boris Riera",34,"Programmer");
     personsList.addPerson(person);

     assertThrows(IllegalArgumentException.class, () -> personsList.findByName("boris riera"));
      }

      @Test
    public void testClone(){
        PersonsList personsList = new PersonsList();
        Person originalPerson = new Person(4, "Luna Hildalgo", 28, "DJ");

        Person clonedPerson = personsList.clone(originalPerson);
        assertNotEquals(originalPerson.getId(),clonedPerson.getId());
        assertEquals(originalPerson.getName(), clonedPerson.getName());
        assertEquals(originalPerson.getAge(), clonedPerson.getAge());
        assertEquals(originalPerson.getOccupation(), clonedPerson.getOccupation());

      }
}
