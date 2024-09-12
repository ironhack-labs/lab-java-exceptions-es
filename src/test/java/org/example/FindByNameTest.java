package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindByNameTest {
     private PersonsList personsList;

        @BeforeEach
        public void setUp() {
            personsList = new PersonsList();
            personsList.add(new Person(1, "Adrian Pintor", 24, "Engineer"));
        }

        @Test
        public void testFindByName() {
            Person foundPerson = personsList.findByName("Adrian Pintor");
            assertEquals(1, foundPerson.getId());
            assertEquals("Adrian Pintor", foundPerson.getName());
            assertEquals(24, foundPerson.getAge());
            assertEquals("Engineer", foundPerson.getOccupation());
        }
}
