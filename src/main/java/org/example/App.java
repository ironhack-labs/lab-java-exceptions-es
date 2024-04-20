package org.example;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IllegalArgumentException, IOException {

        File personFile = new File("persons.txt");
        PersonList personList = new PersonList();

        Person person = new Person (3235,"Miguel Lopez", 22,"Java Developer");
        Person person2 = new Person (3463,"Miguel Lopez", 45,"Java Developer");
        Person person3 = new Person (4632,"Susana Garcia", 34,"IT Technician");

        personList.addPerson(person);
        personList.addPerson(person2);
        personList.addPerson(person3);

        person2.setAge(22);
        person3.setAge(32);

        try {
            person3.setAge(-2);
        } catch (IllegalArgumentException e) {
            System.err.println("Error, edad incorrecta");
        }

        person.equals(person2);
        person.equals(person3);

        Person person4 = person3.clonePerson(person3);
        personList.addPerson(person4);

        try{
            personList.findByName("Roberto gonzalez");
        }catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }

        try{
            personList.findByName("Robertogonzalez");
        }catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        try{
            personList.findByName("Miguel Lopez");
        }catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }



        try {
            person.writePersonToFile(person, "persons.txt");
        } catch (IOException e) {
            System.err.println("No se ha podido escribir en el archivo: " + e.getMessage());
        }

        try {
            person2.writePersonToFile(person2, "persons.txt");
        } catch (IOException e) {
            System.err.println("No se ha podido escribir en el archivo: " + e.getMessage());
        }

        personList.showList();

    }
}
