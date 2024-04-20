package org.example;
import org.junit.jupiter.api.Test;

import  static org.junit.jupiter.api.Assertions.*;


public class PersonsListTest {
    PersonsList personsList = new PersonsList();
    Person person1 = new Person(1, "marcoVillasmil", 29, "Amazon Vendor Support");
    Person person2 = new Person(2, "johnDoe", 30, "Data Analyst");

    @Test
    public void testFindByName() {
        personsList.addPerson(person1);
        personsList.addPerson(person2);
        assertEquals(person1, personsList.findByName("marcoVillasmil"));
        assertEquals(person2, personsList.findByName("johnDoe"));
    }

    @Test
    public void testFindByNameInvalidFormat(){
        personsList.addPerson(person1);
        try {
            personsList.findByName("Marco");
            fail("Expected IllegalArgumentException to be thrown, but nothing was thrown.");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
    }



    @Test
    public void testClone() {
        Person originalPerson = person1;
        personsList.addPerson(originalPerson);

        Person clonedPerson = personsList.clone(originalPerson);

        assertNotEquals(originalPerson.getId(), clonedPerson.getId()); // must be different
        assertEquals(originalPerson.getName(), clonedPerson.getName());
        assertEquals(originalPerson.getAge(), clonedPerson.getAge());
        assertEquals(originalPerson.getOccupation(), clonedPerson.getOccupation());


    }


}
