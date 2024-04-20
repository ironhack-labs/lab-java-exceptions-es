package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    @DisplayName("Test setAge")
    void TestSetAge_ThrowException(){
        Person person = new Person(1, "Jose Perez", 30, "Zapatero");
        assertThrows(IllegalArgumentException.class, () -> {person.setAge(-5);});
        System.out.println("TestSetAge_ThrowException OK!");
    }

    @Test
    @DisplayName("Test findByName con parametros correctos")
    void TestfindByName_CorrectName(){
        PersonsList personsList = new PersonsList();

        Person person1 = new Person(1, "Jose Perez", 30, "Zapatero");
        Person person2 = new Person(2, "Luis Lopez", 50, "Conductor");

        personsList.addPersons(person1);
        personsList.addPersons(person2);


        assertEquals(personsList.findByName("Jose Perez"), person1);
        assertEquals(personsList.findByName("Luis Lopez"), person2);
        System.out.println("TestfindByName_CorrectName OK!");
    }

    @Test
    @DisplayName("Test findByName excepcion con parametros incorrectos")
    void TestfindByName_ThrowException(){
        PersonsList personsList = new PersonsList();

        Person person1 = new Person(1, "Jose Perez", 30, "Zapatero");
        Person person2 = new Person(2, "Luis Lopez", 50, "Conductor");

        personsList.addPersons(person1);
        personsList.addPersons(person2);

        assertThrows(IllegalArgumentException.class, () -> {personsList.findByName("LuisLopez");});
        assertThrows(IllegalArgumentException.class, () -> {personsList.findByName("Jose  Perez");});
        System.out.println("TestfindByName_ThrowException OK!");
    }

    @Test
    @DisplayName("Test clone con mismas propiedades")
    void TestClone(){
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "Jose Perez", 30, "Zapatero");
        Person person2 = new Person(2, "Luis Fernandez", 55, "Conductor");
        Person person3 = new Person(3, "Ricardo Gonzalez", 41, "Chef");
        personsList.addPersons(person1);
        personsList.addPersons(person2);
        personsList.addPersons(person3);
        Person cloned1 = personsList.clone(person1);
        Person cloned3 = personsList.clone(person3);

        assertNotEquals(person1, cloned1);
        assertEquals(person1.getName(), cloned1.getName());
        assertEquals(person1.getAge(), cloned1.getAge());
        assertEquals(person1.getOccupation(), cloned1.getOccupation());
        assertNotEquals(person1.getId(), cloned1.getId());

        assertNotEquals(person3, cloned3);
        assertEquals(person3.getName(), cloned3.getName());
        assertEquals(person3.getAge(), cloned3.getAge());
        assertEquals(person3.getOccupation(), cloned3.getOccupation());
        assertNotEquals(person3.getId(), cloned3.getId());

        System.out.println("TestClone OK!");
    }
}
