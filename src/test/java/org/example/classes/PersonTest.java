package org.example.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    Person person1;

    @BeforeEach
    void init() {
        person1 = new Person("Jaume Sánchez", 31, "Programmer");
    }

    @Test
    void testClone_differentID_ok() {

        assertEquals(person1.getIdentifier() + 1, person1.clone().getIdentifier());
    }

    @Test
    void testClone_clone_ok() {
        assertEquals(person1, person1.clone());

    }


    @Test
    void testClone_sameNameAgeAndOccupation_ok() {
        Person person2 = person1.clone();
        assertEquals(person1.getFullName(), person2.getFullName());
        assertEquals(person1.getYears(), person2.getYears());
        assertEquals(person1.getJobTitle(), person2.getJobTitle());
    }
}