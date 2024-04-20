package org.example;

import org.example.people.Person;
import org.example.people.PersonsList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        // CASO 1
        setAge();
        // CASO 2
        findByName();
        // CASO 3
        errorFindByName();
        // CASO 4
        clonedPerson();
    }

    private static void clonedPerson() {
        PersonsList personsList = new PersonsList();
        Person originalPerson = new Person(1, "Luna Hidalgo", 27, "DJ");
        Person clonedPerson = personsList.clone(originalPerson);
        System.out.println("Person cloned: " + clonedPerson);
    }

    private static void errorFindByName() {
        PersonsList personsList = new PersonsList();
        Person person = new Person(3,"Francisco Diaz", 29, "accountant");
        personsList.addPerson(person);
        try{
            Person foundPerson = personsList.findByName("francisco diaz");
            System.out.println("Person found: " + foundPerson);
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void findByName() {
        PersonsList personsList = new PersonsList();
        Person person = new Person(2,"Boris Riera",34,"Programmer");
        personsList.addPerson(person);
        try {
            Person foundPerson = personsList.findByName("Boris Riera");
            System.out.println("Person found: " + foundPerson);
            } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void setAge() {
        Person person = new Person(1, "Blanca Gomez", 31,"Step up");
        try{
            person.setAge(-31);
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}

