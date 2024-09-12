package org.example;

import java.io.FileWriter;
import java.io.IOException;
public class App {
    public static void main( String[] args ) throws IOException {
        PersonsList list = new PersonsList();
        Person person1 = new Person(1,"Juan Perez", 45, "Teacher");
        Person person2 = new Person(2,"Adrian Pintor",24,"Engineer");
        Person person3 = new Person(3,"Maria Ramos",22,"Teacher");
        list.persons.add(person1);
        list.persons.add(person2);
        list.persons.add(person3);

        Person clonedPerson = list.clone(person1);
        System.out.println(clonedPerson);

        writeFile(list);
    }
    public void writeFile(PersonsList list) {
        try (FileWriter writer = new FileWriter("person_info.txt")) {
            for (Person person : list.persons) {
                writer.write(person.toString() + "\n");
            }
            System.out.println("Información de Personas escrita en el archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
